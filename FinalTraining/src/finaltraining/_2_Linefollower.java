package finaltraining;

import java.util.Timer;

import lejos.nxt.LCD;
import lejos.util.PIDController;

public class _2_Linefollower extends BehaviorParent {

	PIDController controller;
	@Override
	public void action() {
		super.action();
		
		controller=new PIDController(480, 1);
		
		controller.setPIDParam(PIDController.PID_KP, 4);  //5
		controller.setPIDParam(PIDController.PID_KI, 0);
		controller.setPIDParam(PIDController.PID_KD, 0);
		controller.freezeIntegral(true);
		pilot.setAcceleration(160);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		
		us.continuous();
		int counter=0;
		while(!suppressed&&(us.getRange()>20||counter<400))
		{
			LCD.clear(3);
			LCD.drawInt(counter, 4, 0, 3);
			counter++;
			doPID();
		}
		pilot.stop();
		System.exit(0);
		
		while(!suppressed&&!ts1.isPressed())
		{
				doPID();
		}
		
		executed=true;
	}
	
	private void doPID()
	{
		int error=0;
		
		error=controller.doPID(cs.getRawLightValue());
		LCD.clear(4);
		LCD.drawInt(error, 3, 0, 4);
		
		pilot.steer(error/10f);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Line Follower";
	}
}
