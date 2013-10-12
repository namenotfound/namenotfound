package fribot2013;

import lejos.robotics.navigation.Pose;
import lejos.util.Delay;

public class _3GrabBall extends BehaviorParent {

	private int stopDistance=10;
	
	@Override
	public void action() {
		super.action();
		
		
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.goTo(170,60,0);
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
		navi.getPoseProvider().setPose(new Pose(200-(6+stopDistance),60,0));
		pilot.setAcceleration(Constants.ACCELERATION);
		pilot.rotate(180);
		Constants.MOTORMIDDLE.setAcceleration(100);
		Constants.MOTORMIDDLE.setSpeed(40);
		Constants.MOTORMIDDLE.rotate(120,true);
		pilot.travel(-(stopDistance-3));
		
		Constants.MOTORMIDDLE.setAcceleration(100);
		Constants.MOTORMIDDLE.setSpeed(40);
		Constants.MOTORMIDDLE.rotate(-80,true);
		
		
		
		
		pilot.travel((stopDistance-3));	
		
		executed=true;
		
		
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Grab Ball";
	}
	
}
