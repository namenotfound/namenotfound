package pidBot;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Waypoint;

public class Calibrate extends BehaviorParent {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		super.action();
		
		calOdometry();
		
		executed=true;
		
	}
	
	
	private void calOdometry()
	{
		LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
		pilot.travel(30);
		waitForStop();
		LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
		pilot.rotate(90);
		waitForStop();
		LCD.drawString(navi.getPoseProvider().getPose().toString()+"", 0, 2);
		
		navi.goTo(0, 0, 0);
		LCD.drawString(navi.getPoseProvider().getPose().toString()+"", 0, 2);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Calibrate";
	}
	
}
