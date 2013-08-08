package fribot2009;

import lejos.nxt.ColorSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class Calibrate extends BehaviorParent {

	public Calibrate(DifferentialPilot pilot, Navigator navi, UltrasonicSensor us, ColorSensor cs, TouchSensor ts1, TouchSensor ts2) {
		super(pilot, navi, us,cs,ts1,ts2);
		// TODO Auto-generated constructor stub
	}
  
	@Override
	public boolean takeControl() {
		return true;
	}
	
	@Override
	public void action() {
		super.action();
		
		calTravelDistance();
	//	calRotation();
	//	calCentralMotor();
		System.exit(0);
	}
	
	private void calTravelDistance()
	{
		
	}
	
	private void calRotation()
	{
	}
	
	private void calCentralMotor()
	{
		
	}
	
	
}
