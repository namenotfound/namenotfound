package finaltraining;

import lejos.robotics.Color;
import lejos.util.Delay;

public class _1DriveToLine extends BehaviorParent {
	
	@Override
	public void action() {
		super.action();
		pilot.setAcceleration(Constants.DEFAULTACCELERATON);
		pilot.setTravelSpeed(Constants.SPEEDFAST);
		
		//
		navi.goTo(35, 140, 0);
		if(!waitForStop()){
			return;
		}  
		
		// finde schwarze linie
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		pilot.forward();
		while(cs.getColor().getColor() != Color.BLACK){
			Delay.msDelay(50);
			if(suppressed){
				return;
			}
		}
		// finde weisse linie
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		while(cs.getColor().getColor() != Color.WHITE){
			Delay.msDelay(50);
			if(suppressed){
				return;
			}
		}
		pilot.stop();
		pilot.rotate(-90);
		
		executed = true;
	}
	
	@Override
	public String toString() {
		return "Drive to Line";
	}

}
