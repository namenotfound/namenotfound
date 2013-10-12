package fribot2013;

import lejos.nxt.Button;
import lejos.nxt.LCD;
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
		
		pilot.travel(stopDistance -5f);
		pilot.travel(-(stopDistance-3));
		
		boolean lightOn=isOn();
		LCD.clear(4);
		LCD.drawString(lightOn?"On":"Off", 0, 4);
		if(!lightOn)
		{
			pilot.travel(-(stopDistance-3));
			pilot.travel(2*(stopDistance-3));
			pilot.travel(-(stopDistance-3));
		}
		executed = true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Light Our";
	}

}
