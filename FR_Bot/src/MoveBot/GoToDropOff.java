package MoveBot;

import lejos.nxt.ColorSensor.Color;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class GoToDropOff extends BehaviorParent{

	private int color;
	
	public GoToDropOff(DifferentialPilot pilot,int color) {
		super(pilot);
		this.color=color;
	}
	@Override
	public void action() {
		super.action();
		pilot.setTravelSpeed(Constants.speedFast);
		pilot.setAcceleration(25);
		if(color==Color.RED)
		{
		navi.goTo(255, -15, -90);
		}
		else if(color==Color.BLUE)
		{
			navi.goTo(225, 65, 0);
		}
		else{
			System.exit(0);
		}
		if(waitForStop())
		{
			return;
		}
		executed=true;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "GoTo Dropoff";
	}
}
