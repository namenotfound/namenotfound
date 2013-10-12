package fribot2013;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;
import lejos.util.PIDController;

public class _2LightEnenmy extends BehaviorParent {

	
	private int stopDistance=10;
	
	@Override
	public void action() {
		super.action();
		
		
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.goTo(180,35,90);
		if(waitForStop())
		{	
			return;
		}
		
		pilot.setAcceleration(300);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		
		us.continuous();
	
		while(!supressed&&(us.getRange()>stopDistance))
		{
			doPID();
		}
		pilot.stop();
		navi.getPoseProvider().setPose(new Pose(180,stopDistance,90));
		pilot.setAcceleration(Constants.ACCELERATION);
		pilot.travel(stopDistance-2);
		Delay.msDelay(100);	
		pilot.travel(-(stopDistance-2));	
		
		executed=true;
	}
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Light Enemy";
	}
	
}
