package fribot2009;

import lejos.nxt.ColorSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class GotoFinish extends BehaviorParent {

	public GotoFinish(DifferentialPilot pilot, Navigator navi, UltrasonicSensor us, ColorSensor cs, TouchSensor ts1, TouchSensor ts2) {
		super(pilot, navi, us,cs,ts1,ts2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void action() {
		super.action();
		
		pilot.setTravelSpeed(Constants.speedFast);
		navi.goTo(275, 100, 90);
		if(waitForStop())
		{
			return;
		}
		navi.goTo(280, 170, 90);
		if(waitForStop())
		{
			return;
		}
		executed=true;
	}

	
}
