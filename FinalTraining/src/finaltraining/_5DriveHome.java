package finaltraining;

public class _5DriveHome extends BehaviorParent {

	private _3PickBall pb1;

	public _5DriveHome(_3PickBall pb1) {
		this.pb1 = pb1;
	}

	@Override
	public void action() {
		super.action();

		if (pb1.getDetectedColor() == 0) {
			navi.goTo(88, 55, 180);
			if (!waitForStop()) {
				return;
			}
			navi.goTo(20, 20, 180);
			if (!waitForStop()) {
				return;
			}
		} else if (pb1.getDetectedColor() == 2) {
			navi.goTo(88, 55, 180);
			if (!waitForStop()) {
				return;
			}			
			navi.goTo(20, 55, -90);
			if (!waitForStop()) {
				return;
			}
			navi.goTo(20, 180, 0);
			if (!waitForStop()) {
				return;
			}
			navi.goTo(73, 180, 0);
			if (!waitForStop()) {
				return;
			}
		}

		executed = true;
	}

	@Override
	public String toString() {
		return "Drive Home";
	}

}
