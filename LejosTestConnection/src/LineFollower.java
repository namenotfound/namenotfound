import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.SensorMode;

public class LineFollower extends BehaviorParent {

	PIDController controller=new PIDController(0, 1);
	
	@Override
	public void action() {
		executed=true;
		initBehavior();
		int steerval=0;
		int lightval=0;
		controller.setPIDParam(PIDController.PID_KP, 3f);
		controller.setPIDParam(PIDController.PID_KI, 0.00f);
		controller.setPIDParam(PIDController.PID_KD, 0);
		controller.setPIDParam(PIDController.PID_LIMITHIGH, 200);
		controller.setPIDParam(PIDController.PID_LIMITLOW, -200);
		controller.setPIDParam(PIDController.PID_I_LIMITHIGH, 200);
		controller.setPIDParam(PIDController.PID_I_LIMITLOW, -200);
		controller.setPIDParam(PIDController.PID_SETPOINT, 35);
		
		
		controller.freezeIntegral(false);

	//	controller.setPIDParam(PIDController.PID_DEADBAND, 10);

		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		pilot.forward();
		pilot.setAcceleration(80);  //160
		Constants.COLOR.setFloodlight(true);
		SensorMode lightMode=Constants.COLOR.getRedMode();
		while(!suppressed)
		{
			float[] values=new float[lightMode.sampleSize()];
			lightMode.fetchSample(values, 0);
			lightval=(int)(values[0]*100);
			steerval=controller.doPID(lightval);
			

			LCD.drawInt(lightval,3, 0, 2);
			LCD.drawInt(steerval,4, 0, 3);
			
			pilot.steer(steerval);
			
		}
		pilot.stop();
		pilot.setAcceleration(Constants.ACCELERATION);
	

	}

	@Override
	public String toString() {
		return "Line Follower";
	}
	
}
