package MoveBot;

import lejos.nxt.LCD;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;
import lejos.robotics.subsumption.Behavior;

public abstract class BehaviorParent implements Behavior {

	protected DifferentialPilot pilot;
	protected boolean supressed = false;
	protected boolean executed = false;
	protected Navigator navi;

	public boolean isExecuted() {
		return executed;
	}

	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	public BehaviorParent(DifferentialPilot pilot) {
		super();
		this.pilot = pilot;
		navi = new Navigator(pilot);
		navi.getPoseProvider().setPose(new Pose(22, -7, 0));
	}

	@Override
	public void suppress() {
		supressed = true;
	}

	@Override
	public void action() {
		supressed = false;
		LCD.clear(2);
		LCD.drawString(this.toString(), 0, 2);
		Sound.playTone(2500, 500);
	}

	@Override
	public boolean takeControl() {

		return !executed;
	}

	protected boolean waitForMotorStop(NXTRegulatedMotor motor) {
		while (motor.isMoving()) {
			if (supressed) {
				return true;
			}
			Thread.yield();
		}
		return false;
	}

	private boolean waitForPilotStop() {
		while (pilot.isMoving()) {
			if (supressed) {
				return true;
			}
			Thread.yield();
		}
		return false;
	}

	private boolean waitForNaviStop() {
		while (navi.isMoving()) {
			if (supressed) {
				return true;
			}
			Thread.yield();
		}
		return false;
	}

	protected boolean waitForStop()
	{
		if(pilot.isMoving())
		{
			return waitForPilotStop();
		}
		else if(navi.isMoving())
		{
			return waitForNaviStop();
		}
		return false;
	}
	
	protected void rotate(int angle, Boolean imediateReturn) {
		float current = (float) navi.getPoseProvider().getPose().getHeading();
		navi.rotateTo(current + angle);
		if (!imediateReturn) {
			while (navi.isMoving()) {
				Thread.yield();
			}
		}
	}

	protected void travel(int distance, Boolean imediateReturn) {
		float currentx = navi.getPoseProvider().getPose().getX();
		float currenty = navi.getPoseProvider().getPose().getY();
		float heading = navi.getPoseProvider().getPose().getHeading();

		float y = (float) Math.sin(heading * Math.PI / 180) * distance;
		float x = (float) Math.cos(heading * Math.PI / 180) * distance;

		if (distance > 0) {
			navi.goTo(currentx + x, currenty + y, heading);
			if (!imediateReturn) {
				while (navi.isMoving()) {
					Thread.yield();
				}
			}
		} else {
			navi.getPoseProvider().setPose(new Pose(currentx+x, currenty+y, heading));
			pilot.travel(distance,imediateReturn);
		}

	}

}
