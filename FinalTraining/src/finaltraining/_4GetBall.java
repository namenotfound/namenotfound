package finaltraining;

import lejos.util.Delay;

public class _4GetBall extends BehaviorParent {

	@Override
	public void action() {
		super.action();

		navi.goTo(225, 125, 0);
		if (!waitForStop()) {
			return;
		}

		adjust(50, 1, false);
		pilot.travel(us.getRange() - 3);
		
		Constants.MOTORMIDDLE.setAcceleration(900);
		Constants.MOTORMIDDLE.rotate(100);

		executed = true;
	}

	@Override
	public String toString() {
		return "Get Ball";
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
