package shooter;

import lejos.robotics.navigation.DifferentialPilot;

public class Forward extends BehaviorParent {

	public Forward(DifferentialPilot pilot) {
		super(pilot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		super.action();
		pilot.setAcceleration(100);
		pilot.setTravelSpeed(Constants.speedNormal);
		while(!supressed)
		{
			travel(200, true);
			waitForStop();
		}
		navi.stop();
		navi.clearPath();
		return;
	}

	
	
}
