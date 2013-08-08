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
			range = us.getDistance();
			if(range <= 30){
				objectFound = true;
			}
			Delay.msDelay(200);
		}
		
		// if there's an object
		if (objectFound){
			navi.stop();
			navi.clearPath();
			
			rotate(90, true);
			if (waitForStop()){
				return;
			}
			travel(range, true);
			if (waitForStop()){
				return;
			}
			rotate(-90, true);
			if (waitForStop()){
				return;
			}
		}
		
		// goTo behavior end position
		pilot.setTravelSpeed(Constants.speedFast);
		float currentY = navi.getPoseProvider().getPose().getY();
		navi.goTo(210, currentY);
	}

	
}
