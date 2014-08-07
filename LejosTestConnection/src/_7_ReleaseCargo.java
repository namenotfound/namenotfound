import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.SampleProvider;


public class _7_ReleaseCargo extends BehaviorParent {

	
	PIDController controller=new PIDController(0, 1);
	
	@Override
	public void action() {
		executed = true;
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
		
		Constants.US.enable();
		SampleProvider touchProvider = Constants.TOUCH1.getTouchMode();
		float[] samples = new float[touchProvider.sampleSize()];
		float[] values=new float[lightMode.sampleSize()];
		int dist=0;
		while(!suppressed)
		{
			
			
			touchProvider.fetchSample(samples, 0);
			dist = (int)(samples[0]);
			
			if(dist>0){
				pilot.stop();
				Constants.MOTORMIDDLE.setAcceleration(720);
				Constants.MOTORMIDDLE.setSpeed(720);
				Constants.MOTORMIDDLE.rotate(-100);
				break;
			}
			

			lightMode.fetchSample(values, 0);
			lightval=(int)(values[0]*100);
			steerval=controller.doPID(lightval);
			

			LCD.drawInt(lightval,3, 0, 2);
			LCD.drawInt(steerval,4, 0, 3);
			LCD.clear(5);
			LCD.drawInt(dist,5, 0, 3);
			
			pilot.steer(steerval);
			
		}
		pilot.stop();
		pilot.setAcceleration(Constants.ACCELERATION);
		
	}
	@Override
	public String toString() {
		return "ReleaseCargo";
	}
}
