package MoveBot;

import lejos.robotics.navigation.DifferentialPilot;

public class DropOffObject  extends BehaviorParent{
	
	
	public DropOffObject(DifferentialPilot pilot) {
		super(pilot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		super.action();
		Constants.motorCentral.setSpeed(Constants.centralMotorSpeed);
		Constants.motorCentral.rotate(-Constants.centralMotorDist,true);
		if(waitForMotorStop(Constants.motorCentral))
		{
			return;
		}		
		pilot.setTravelSpeed(Constants.speedFast);
		travel(-20,true);
		if(waitForStop())
		{
			return;
		}
		executed=true;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Dropping off...";
	}
}
