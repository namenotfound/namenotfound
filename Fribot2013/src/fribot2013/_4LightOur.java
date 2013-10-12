package fribot2013;

import lejos.robotics.navigation.Pose;

public class _4LightOur extends BehaviorParent {

	private int stopDistance = 10;

	@Override
	public void action() {
		super.action();

		pilot.setAcceleration(Constants.ACCELERATION);
		navi.goTo(180, 85, -90);
		if (waitForStop()) {
			return;
		}

		pilot.setAcceleration(300);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);

		us.continuous();

		while (!supressed && (us.getRange() > stopDistance)) {
			doPID();
		}
		pilot.stop();
		navi.getPoseProvider().setPose(new Pose(180, 120 - stopDistance, 0));
		pilot.setAcceleration(Constants.ACCELERATION);
		
		boolean open=false;
		do{
			pilot.travel(stopDistance - 2);
			pilot.travel(-3);
			open=isOn();
			pilot.travel(-(stopDistance-5));
		}while(!open);
			

		executed = true;
	}

	private boolean isOn() {
		int offcount = 0;
		int oncount = 0;
		for (int i = 0; i < 7; i++) {
			int lightVal = lightHor.getLightValue();
			if (lightVal > 450) {
				oncount++;
			} else {
				offcount++;
			}

		}
		return oncount < offcount;
	}

}
