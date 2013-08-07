package MoveBot;

import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.robotics.Color;
import lejos.robotics.navigation.DifferentialPilot;

public class SearchDropoffArea extends BehaviorParent{

	
	private ColorSensor cs;
	private int color;
	
	public SearchDropoffArea(DifferentialPilot pilot,int color) {
		super(pilot);
	cs=new ColorSensor(SensorPort.S3);
	this.color=color;
	}
	
	
	@Override
	public void action() {
		super.action();
		boolean detected=false;
		pilot.setTravelSpeed(Constants.speedSlow);
		pilot.setAcceleration(100);
		pilot.forward();
		while(!detected)
		{
			if(supressed)
			{
				return;
			}
			Color c=cs.getColor();
			detected=c.getColor()==color;
		}
		pilot.stop();		
		executed=true;
	}
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Searching Dropoff...";
	}
	
}
