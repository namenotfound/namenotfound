package fribot2013;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;

public class _3GrabBall extends BehaviorParent {

	private int stopDistance=10;
	int count=0;
	@Override
	public void action() {
		super.action();
		if(executed)
		{
			return;
		}
		
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.goTo(165,64,0);
		if(waitForStop())
		{	
			
		}
		
		
		pilot.setAcceleration(300);
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		
		us.continuous();
	
		while(!supressed&&(us.getRange()>stopDistance))
		{
			doPID(-1);
		}
		pilot.stop();
		navi.getPoseProvider().setPose(new Pose(200-(6+stopDistance),120-60,0));
		pilot.setAcceleration(Constants.ACCELERATION);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		pilot.travel(-25);
		stopDistance+=25;
		pilot.rotate(178);
		Constants.MOTORMIDDLE.setAcceleration(900);
		Constants.MOTORMIDDLE.rotate(180);
	
		pilot.travel(-(stopDistance-19));
		
		Constants.MOTORMIDDLE.setAcceleration(100);
		Constants.MOTORMIDDLE.rotate(-60);
		
		pilot.travel(10);	
		
		executed=true;
		
		LCD.clear(3);
		LCD.drawString("Homo "+count, 0, 3);
		count++;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Grab Ball";
	}
	
}
