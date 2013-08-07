package MoveBot;

import lejos.robotics.navigation.DifferentialPilot;

public class PickUpObject extends BehaviorParent{

	public PickUpObject(DifferentialPilot pilot) {
		super(pilot);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void action() {
		super.action();
		Constants.motorCentral.setSpeed(Constants.centralMotorSpeed);
		Constants.motorCentral.rotate(Constants.centralMotorDist,true);
		if(waitForMotorStop(Constants.motorCentral))
		{
			return;
		}		
		executed=true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Picking up...";
	}

}
