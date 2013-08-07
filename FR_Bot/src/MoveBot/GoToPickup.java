package MoveBot;

import lejos.robotics.navigation.DifferentialPilot;

public class GoToPickup extends BehaviorParent{

	public GoToPickup(DifferentialPilot pilot) {
		super(pilot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		super.action();
		pilot.setTravelSpeed(Constants.speedFast);
		navi.goTo(125, 45, 0);
		if(waitForStop())
		{
			return;
		}
		executed=true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoTo Pickup";
	}
}
