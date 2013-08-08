package fribot2009;

import lejos.nxt.Button;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class Abort extends BehaviorParent {

	public Abort(DifferentialPilot pilot, Navigator navi) {
		super(pilot, navi, null, null, null, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean takeControl() {
		return Button.ESCAPE.isDown();
	}

	@Override
	public void action() {
		super.action();
		System.exit(0);
	}

}
