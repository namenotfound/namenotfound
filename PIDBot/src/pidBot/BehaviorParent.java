package pidBot;

import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Behavior;

public abstract class BehaviorParent implements Behavior {

	private boolean supressed=false;
	protected DifferentialPilot pilot=Constants.PILOT;
	protected Navigator navi=Constants.NAVI;
	protected TouchSensor ts1=Constants.TS1;
	protected TouchSensor ts2=Constants.TS2;
	protected UltrasonicSensor us=Constants.US;
	protected LightSensor light=Constants.LIGHT;
	protected OdometryPoseProvider pose=Constants.POSE;
	
	@Override
	public void action() {
		supressed=false;
		LCD.clear(2);
		LCD.drawString(this.toString(), 0, 2);
		Sound.playTone(2500, 500);
	}

	@Override
	public void suppress() {
		supressed=true;
		
	}


	
	
}
