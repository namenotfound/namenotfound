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
		travel(50,true);
		if(waitForStop())
		{
			return;
		}
		navi.goTo(0, 0,0);
		if(waitForStop())
		{
			return;
		}	
		executed=true;
	}

	
	private boolean search()
	{
		us.continuous();
		int range;
		for(int i=0;i<3;i++)
		{
			range=(int)us.getRange();
			if(range>30)
			{
				break;
			}
			travel(25, true);
			if(waitForStop())
			{
				return true;
			}
		}
		rotate(90, true);
		if(waitForStop())
		{
			return true;
		}	
		return false;
	}
	
	
}
