package hsluchallange;

import java.util.ArrayList;

import lejos.nxt.ColorSensor;

public class DestroyBalloon extends BehaviorParent {

	private int executions = 0;
	private int hitDistanze = 8;
	private boolean canExecute = true;

	SpecialBlue sbBlue;

	public DestroyBalloon(SpecialBlue sBlue) {
		this.sbBlue = sBlue;
	}

	public void enable() {
		executed = false;
	}

	@Override
	public void action() {
		if (canExecute) {
			super.action();
			pilot.setTravelSpeed(Constants.SPEEDTOUCH);
			pilot.forward();
			us.continuous();
			while (!supressed && us.getRange() > hitDistanze) {
				Thread.yield();
			}
			pilot.stop();
			if (supressed) {
				return;
			}
			executions++;
			int color = light.getColor().getColor();
			if (color == 2) {
				if (executions == 1) {

					sbBlue.setExecuted(true);
					executed = true;
					return;
				}
				canExecute=false;
			}
			Constants.MOTORMIDDLE.setAcceleration(900);
			Constants.MOTORMIDDLE.rotate(20);
			Constants.MOTORMIDDLE.rotate(-20, true);
			pilot.travel(-(15 - hitDistanze));
			if (waitForStop()) {
				executed = true;
				return;
			}
		}
		executed = true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Destroy";
	}
}
