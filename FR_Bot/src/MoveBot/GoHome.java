package MoveBot;

import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class GoHome extends BehaviorParent{
	
	public GoHome(DifferentialPilot pilot) {
		super(pilot);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void action() {
		super.action();
		pilot.setTravelSpeed(Constants.speedFast);
		navi.goTo(22, -8, 0);
		if(waitForStop())
		{
			return;
		}
		executed=true;
		travel(-5, false);
		waitForStop();
		System.exit(0);
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Goto Home";
	}
}
