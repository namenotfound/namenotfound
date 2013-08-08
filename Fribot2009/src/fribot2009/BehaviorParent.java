package fribot2009;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Behavior;

public class BehaviorParent implements Behavior {
	
	protected boolean suppressed = false;
	protected boolean executed = false;
	protected DifferentialPilot pilot;
	protected Navigator navi;
	
	public BehaviorParent(DifferentialPilot pilot, Navigator navi){
		this.pilot = pilot;
		this.navi = navi;
	}

	@Override
	public boolean takeControl() {
		return executed;
	}

	@Override
	public void action() {
		suppressed = false;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

}
