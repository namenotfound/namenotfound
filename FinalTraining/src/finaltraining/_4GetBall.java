package finaltraining;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;

public class _4GetBall extends BehaviorParent {

	@Override
	public void action() {
		super.action();

		navi.getPoseProvider().setPose(new Pose(260, 50, 0));
		pilot.setTravelSpeed(Constants.SPEEDFAST);
		pilot.travel(-20, true);
		if (!waitForStop()) {
			return;
		}

		navi.goTo(220, 130, 0);
		if (!waitForStop()) {
			return;
		}
		us.continuous();
		int range=51;
		while(range>50)
		{
		range =findObject(range, 1);
				if(suppressed)
				{
					return;
				}
				pilot.rotate(-45);
				pilot.travel(10);
				pilot.rotate(-45);
		}
			range=	adjust(range, 1, false);
		pilot.travel(range - 6);

		Constants.MOTORMIDDLE.setAcceleration(900);
		Constants.MOTORMIDDLE.rotate(160);

		executed = true;
	}

	@Override
	public String toString() {
		return "Get Ball";
	}

	private int findObject(int range, int dir) {
		int counter=0;
		while (!suppressed&&counter<=18) {
			counter++;
			pilot.rotate(5 * dir);
			Delay.msDelay(100);
			int tmprng = (int) us.getRange();
			LCD.clear(4);
			LCD.drawInt(tmprng, 0, 4);
			if (tmprng < range) {
				return tmprng;
			}
		}
		return range;
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
