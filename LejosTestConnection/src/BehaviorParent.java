import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Behavior;

public abstract class BehaviorParent implements Behavior {

	protected boolean suppressed = false;
	protected boolean executed = false;

	protected DifferentialPilot pilot=Constants.PILOT;
	protected Navigator navi=Constants.NAVI;

	protected boolean waitFOrStop() {

		if (navi.isMoving()) {
			return waitForNaviStop();
		}
		if (pilot.isMoving()) {
			return waitForPilotStop();
		}
		return false;
	}

	private boolean waitForNaviStop() {
		while (navi.isMoving()) {
			if (suppressed) {
				navi.stop();
				return true;
			}
			Thread.yield();
		}
		return false;
	}

	private boolean waitForPilotStop() {
		while (pilot.isMoving()) {
			if (suppressed) {
				pilot.stop();
				return true;
			}
			Thread.yield();
		}
		return false;
	}

	protected void initBehavior() {
		suppressed = false;
		LCD.clear(1);
		LCD.drawString(this.toString(), 0, 1);
		Sound.playTone(2500, 200);
	}

	@Override
	public boolean takeControl() {
		return !executed;
	}
	
	@Override
	public void suppress() {
		suppressed = true;
	}

}
