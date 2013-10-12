package fribot2013;

import lejos.robotics.navigation.Pose;

public class _4LightOur extends BehaviorParent {

	private int stopDistance = 10;

	@Override
	public void action() {
		super.action();
		if(executed)
		{
			return;
		}
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.goTo(178, 30, -90);
		if (waitForStop()) {
			return;
		}

		pilot.setAcceleration(300);
		pilot.setTravelSpeed(Constants.SPEEDSLOW);

		us.continuous();

		while (!supressed && (us.getRange() > stopDistance)) {
			doPID(1);
		}
		pilot.stop();
		navi.getPoseProvider().setPose(new Pose(180, stopDistance+1, -90));
		pilot.setAcceleration(Constants.ACCELERATION);
		
		pilot.travel(stopDistance -6f);
		pilot.travel(-(stopDistance-3));
		
		executed = true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Light Our";
	}

}
