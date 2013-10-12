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
		
	controller=new PIDController(185, 1);
	
	controller.setPIDParam(PIDController.PID_KP, 4);  //5
	controller.setPIDParam(PIDController.PID_KI, 0f);
	controller.setPIDParam(PIDController.PID_KD, 0);
	controller.freezeIntegral(true);
	}
	
	
	protected void doPID()
	{
		int error=0;
		error=controller.doPID(light.getNormalizedLightValue());
		LCD.clear(4);
		LCD.drawInt(error, 3, 0, 4);

		pilot.steer(error/10f);
		
	}
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return !executed;
	}

	@Override
	public void action() {
		supressed = false;
		LCD.clear(2);
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
