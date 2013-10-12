package hsluchallange;

import fribot2013.BehaviorParent;
import fribot2013.Constants;
import lejos.util.Delay;

public class DriveToStart extends BehaviorParent {

	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		super.action();
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);

		navi.goTo((float) Constants.START.getX()-25, (float) Constants.START.getY()+60, -45f);
		if (waitForStop()) {
			return;
		}
		
		Delay.msDelay(1000);
		
		adjust(50, -1, false);
		
		pilot.travel(80);
		
		pilot.rotate(180);
		
		pilot.travel(200);
		
		pilot.rotate(-90);
		
		pilot.travel(300);
		
		pilot.rotate(90);
		
		pilot.travel(-30);
		
		executed = true;
		
		
		
	}
	
	private int adjust(int range, int dir, boolean gotBEtter) {
		pilot.rotate(5 * dir, true);
		Delay.msDelay(100);
		int tmprng = (int) us.getRange();
		if (tmprng > range) {
			dir *= -1;
			if (gotBEtter) {
				pilot.rotate(13 * dir, false);
				return (int) us.getRange();
			}
		} else {
			gotBEtter = true;
		}
		range = tmprng;
		return adjust(range, dir, gotBEtter);
	}
	
}
