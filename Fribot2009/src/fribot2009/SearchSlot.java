package fribot2009;

import lejos.nxt.ColorSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class SearchSlot extends BehaviorParent {

	public SearchSlot(DifferentialPilot pilot, Navigator navi, UltrasonicSensor us, ColorSensor cs, TouchSensor ts1, TouchSensor ts2) {
		super(pilot, navi, us,cs,ts1,ts2);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void action() {
		super.action();
		navi.goTo(0, 0, -90);
		if(waitForStop())
		{
			return;
		}
		if(search())
		{
			return;
		}
		
	}

	
	private boolean search()
	{
		
		
		return false;
	}
	
	
}