package pidBot;

import lejos.nxt.LCD;
import lejos.util.PIDController;

public class LineFollower extends BehaviorParent {

	PIDController controller;
	
	private int middle=490;
	
	public LineFollower()
	{
		controller=new PIDController(middle, 1);
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		super.action();
		int steerval=0;
		int lightval=0;
		controller.setPIDParam(PIDController.PID_KP, 11);
		controller.setPIDParam(PIDController.PID_KI, 0.001f);
		controller.setPIDParam(PIDController.PID_KD, 60);
		controller.freezeIntegral(false);
	//	controller.setPIDParam(PIDController.PID_LIMITLOW, -2000);
	//	controller.setPIDParam(PIDController.PID_I_LIMITHIGH, 2000);
	//	controller.setPIDParam(PIDController.PID_I_LIMITLOW, 3);
		controller.setPIDParam(PIDController.PID_DEADBAND, 10);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		pilot.forward();
		pilot.setAcceleration(160);  //160
		int time=0;
		while(!supressed&&time<30000)
		{
			lightval=light.getRawLightValue();
			steerval=controller.doPID(lightval);
			
			LCD.drawInt(lightval,3, 0, 2);
			LCD.drawInt(steerval,4, 0, 3);
			LCD.drawInt(time,4, 0, 4);
			
			pilot.steer(steerval/10f);
			time++;
			
		}
		pilot.stop();
		pilot.setAcceleration(40);
	
		executed=true;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Line Follower";
	}
	
}
