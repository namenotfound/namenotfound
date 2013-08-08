package fribot2009;

import lejos.nxt.ColorSensor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.util.Delay;

public class PushObject extends BehaviorParent {

	public PushObject(DifferentialPilot pilot, Navigator navi, UltrasonicSensor us, ColorSensor cs, TouchSensor ts1, TouchSensor ts2) {
		super(pilot, navi, us,cs,ts1,ts2);
		us.continuous();
	}

	
	@Override
	public void action() {
		super.action();
		int range = 0;
		boolean objectFound = false;
		
		pilot.setTravelSpeed(Constants.speedSlow);
		travel(68, true);
		while(!objectFound && navi.isMoving()){
			Delay.msDelay(200);
			range = us.getDistance();
			if(range <= 30){
				objectFound = true;
			}
			
		}
		
		// if there's an object
		if (objectFound){
			navi.stop();
			navi.clearPath();
			
			travel(-2,true);
			if (waitForStop()){
				navi.stop();
				navi.clearPath();
				return;
			}
			rotate(90, true);
			if (waitForStop()){
				navi.stop();
				navi.clearPath();
				return;
			}
			pilot.setTravelSpeed(Constants.speedSlow);
			travel(range+10, true);
			while(!ts1.isPressed()||!ts2.isPressed())
			{
				if(suppressed)
				{
					navi.stop();
					navi.clearPath();
					return;
				}
				Thread.yield();
			}
			navi.stop();
			navi.clearPath();
			pilot.setTravelSpeed(Constants.speedInsane);
			travel(-range, true);
			if (waitForStop()){
				return;
			}
		}
		
		// goTo behavior end position
		pilot.setTravelSpeed(Constants.speedInsane);
		navi.goTo(210, 65,0);
		if(waitForStop())
		{
			navi.stop();
			navi.clearPath();
			return;
		}
		executed = true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Push Object";
	}
	
}
