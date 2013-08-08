package fribot2009;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class Calibrate extends BehaviorParent {

	public Calibrate(DifferentialPilot pilot, Navigator navi) {
		super(pilot, navi, null, null, null, null);
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
