package finaltraining;

import lejos.robotics.Color;
import lejos.util.Delay;

public class _3PickBall extends BehaviorParent {
	
	private int detectedColor=0;
	
	@Override
	public String toString() {
		return "Pick Ball";
	}
	
	@Override
	public void action() {
		super.action();
		
		pilot.setAcceleration(Constants.DEFAULTACCELERATON);
		pilot.setTravelSpeed(Constants.SPEEDFAST);
		// rückwärts fahren
		pilot.travel(-10,true);
		if(!waitForStop()){
			return;
		}
		// vors Blatt fahren
		navi.goTo(250, 50, 0);
		if(!waitForStop()){
			return;
		}
		// suche farbe auf blatt
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		pilot.forward();
		while (cs.getColor().getColor() != Color.BLUE && cs.getColor().getColor() != Color.RED) {
			if(suppressed){
				return;
			}
			Delay.msDelay(50);
		}
		pilot.stop();
		detectedColor = cs.getColor().getColor();
		
		executed = true;
	}
	
	public int getDetectedColor(){
		return detectedColor;
	}
	

}
