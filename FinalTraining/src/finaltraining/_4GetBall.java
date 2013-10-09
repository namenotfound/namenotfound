package finaltraining;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;

public class _4GetBall extends BehaviorParent {

	@Override
	public void action() {
		super.action();

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
		int range = 21;
		int max=21;
		int count=1;
		while (range > max-1) {
			LCD.drawInt(max, 0, 5);
			count++;
			range = findObject(range, 1,18);
			if (suppressed) {
				return;
			}
			if (range > max-1) {
				//max-=5;
				range=max;
				if(count>6)
				{
					break;
				}
				if(max<=1)
				{
					break;
				}
				pilot.rotate(-45);
				pilot.travel(10);
				pilot.rotate(-45);
			}
		}
		range = adjust(range, 1, false);
		pilot.travel(range - 6);

		Constants.MOTORMIDDLE.setAcceleration(900);
		Constants.MOTORMIDDLE.rotate(160);
		

		executed = true;
	}

	@Override
	public String toString() {
		return "Get Ball";
	}

	private int findObject(int range, int dir,int runs) {
		int counter = 0;
		while (!suppressed && counter <= runs) {
			counter++;
			pilot.rotate(5 * dir);
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
