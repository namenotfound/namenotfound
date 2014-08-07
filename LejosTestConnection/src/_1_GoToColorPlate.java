import lejos.robotics.navigation.Pose;

public class _1_GoToColorPlate extends BehaviorParent {

	@Override
	public void action() {
		executed = true;
		initBehavior();
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);

		navi.getPoseProvider().setPose(new Pose(20.5f, 24.75f, 0));

		/*
		 * navi.goTo(50, 80, 0); if(waitFOrStop()) { return; }
		 */
		navi.goTo(224, 102, 0);
		if (waitFOrStop()) {
			return;
		}
	}

	@Override
	public String toString() {
		return "Goto Colorplate";
	}

}
