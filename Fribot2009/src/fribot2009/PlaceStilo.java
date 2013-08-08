package fribot2009;

import lejos.nxt.ColorSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.util.Delay;

public class PlaceStilo extends BehaviorParent {

	public PlaceStilo(DifferentialPilot pilot, Navigator navi, UltrasonicSensor us, ColorSensor cs, TouchSensor ts1, TouchSensor ts2) {
		super(pilot, navi, us,cs,ts1,ts2);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void action() {
		super.action();
		pilot.setTravelSpeed(Constants.speedSlow);
		travel(200,true);
		while(cs.getColor().getColor()!=cs.BLACK)
		{
			if(suppressed)
			{
				navi.stop();
				navi.clearPath();
				return;
			}
			Thread.yield();
		}
		while(!ts1.isPressed()||ts2.isPressed())
		{
			if(cs.getColor().getColor()!=cs.BLACK)
			{
				navi.stop();
				navi.clearPath();
				while(cs.getColor().getColor()!=cs.BLACK)
				{
					rotate(5, true);
					if(waitForStop())
					{
						return;
					}
				}
				travel(100,true);
			}if(suppressed)
			{
				navi.stop();
				navi.clearPath();
			}
		}
		navi.stop();
		navi.clearPath();
		Constants.motorCentral.setSpeed(Constants.motorCentralSpeed);
		Constants.motorCentral.rotate(Constants.motorCentralRotVal,true);
		if(waitForMotorStop(Constants.motorCentral))
		{
			return;
		}
		Constants.motorCentral.rotate(-Constants.motorCentralRotVal,true);
		if(waitForMotorStop(Constants.motorCentral))
		{
			return;
		}
		travel(-30,true);
		if(waitForStop())
		{
			return;
		}
		executed=true;
	}

	
}
