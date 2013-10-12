package fribot2013;

import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.Sound;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.PIDController;

public abstract class BehaviorParent implements Behavior {

	protected boolean supressed = false;
	protected boolean executed = false;
	protected DifferentialPilot pilot = Constants.PILOT;
	protected Navigator navi = Constants.NAVI;
	protected TouchSensor ts1 = Constants.TS1;
	protected TouchSensor ts2 = Constants.TS2;
	protected UltrasonicSensor us = Constants.US;
	protected LightSensor light = Constants.LIGHT;
	protected LightSensor lightHor=Constants.LIGHTHOR;

	protected PIDController controller;
	
	public BehaviorParent()
	{
		
	controller=new PIDController(550, 1);
	light.setFloodlight(true);
	
	controller.setPIDParam(PIDController.PID_KP, 4);  //5
	controller.setPIDParam(PIDController.PID_KI, 0f);
	controller.setPIDParam(PIDController.PID_KD, 0);
	controller.freezeIntegral(true);
	}
	
	protected boolean isOn() {
		int offcount = 0;
		int oncount = 0;
		for (int i = 0; i < 7; i++) {
			int lightVal = lightHor.getLightValue();
			if (lightVal > 450) {
				oncount++;
			} else {
				offcount++;
			}

		}
		return oncount < offcount;
	}
	
	
	protected void doPID(int dir)
	{
		int error=0;
		int lightVal=light.getNormalizedLightValue();
		error=controller.doPID(lightVal);
		LCD.clear(5);
		LCD.drawInt(lightVal, 3, 0, 5);
		LCD.clear(4);
		LCD.drawInt(error*dir, 3, 0, 4);

		pilot.steer(error*dir/2f);
		
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return !executed;
	}

	@Override
	public void action() {
		supressed = false;
		LCD.clear(1);
		LCD.drawString(this.toString(), 0, 1);
		Sound.playTone(2500, 500);
	}

	@Override
	public void suppress() {
		supressed = true;

	}

	protected boolean waitForStop() {
		if (navi.isMoving()) {
			return waitForNaviStop();
		}
		if (pilot.isMoving()) {
			return waitForPilotStop();
		}
		return false;
	}

	private boolean waitForNaviStop() {
		while (navi.isMoving()) {
			if (supressed) {
				navi.stop();
				navi.clearPath();
				return true;
			}
			Thread.yield();
		}
		return false;
	}

	//test
	private boolean waitForPilotStop() {
		while (pilot.isMoving()) {
			if (supressed) {
				pilot.stop();
				return true;
			}
			Thread.yield();
		}
		return false;
	}

}
