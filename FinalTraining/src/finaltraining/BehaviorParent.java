package finaltraining;

import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Behavior;

public abstract class BehaviorParent implements Behavior{
	
	protected boolean executed = false;
	protected boolean suppressed = false;
	
	protected Navigator navi = Constants.NAVI;
	protected DifferentialPilot pilot = Constants.PILOT;
	protected UltrasonicSensor us = Constants.US;
	protected ColorSensor cs = Constants.LIGHT;
	protected TouchSensor ts1 = Constants.TS1;
	protected TouchSensor ts2 = Constants.TS2;

	
	@Override
	public boolean takeControl() {
		return !executed;
	}

	@Override
	public void action() {
		LCD.drawString(this.toString(), 0, 2);
		Sound.playTone(2000, 200);
		suppressed = false;
	}

	@Override
	public void suppress() {
		suppressed = true;		
	}

	@Override
	public String toString() {
		return "Behavoir Parent";
	}
	
	// return false when suppressed
	protected  boolean waitForStop() {
		if (navi.isMoving()){
			return waitForNaviStop();
		} else if (pilot.isMoving()){
			return waitForPilotStop();
		}
		return true;
	}
	
	private boolean waitForNaviStop(){
		while(navi.isMoving()){
			if(suppressed){
				navi.stop();
				navi.clearPath();
				return false;
			}
		}
	}
	
	private boolean waitForPilotStop(){
		while(pilot.isMoving()){
			if(suppressed){
				pilot.stop();
				return false;
			}
		}
		return true;
	}

}
