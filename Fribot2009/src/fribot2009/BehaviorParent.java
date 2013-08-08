package fribot2009;

import lejos.nxt.ColorSensor;
import lejos.nxt.NXTMotor;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;
import lejos.robotics.subsumption.Behavior;

public class BehaviorParent implements Behavior {

	protected boolean suppressed = false;
	protected boolean executed = false;
	protected DifferentialPilot pilot;
	protected Navigator navi;
	protected UltrasonicSensor us;
	protected ColorSensor cs;
	protected TouchSensor ts1;
	protected TouchSensor ts2;

	public BehaviorParent(DifferentialPilot pilot, Navigator navi, UltrasonicSensor us, ColorSensor cs, TouchSensor ts1, TouchSensor ts2) {
		this.pilot = pilot;
		this.navi = navi;
		this.us = us;
		this.cs = cs;
		this.ts1 = ts1;
		this.ts2 = ts2;		
	}

	@Override
	public boolean takeControl() {
		return !executed;
	}

	@Override
	public void action() {
		suppressed = false;
	}

	@Override
	public void suppress() {
		suppressed = true;
	}

	protected void rotate(int angle, boolean imediateReturn) {
		float currentHeading = navi.getPoseProvider().getPose().getHeading();
		navi.rotateTo(currentHeading + angle);
		
		if(!imediateReturn){
			while(navi.isMoving()){
				Thread.yield();
			}
		}
	}
	
	protected void travel(int distance, boolean imediateReturn){
		float currentX = navi.getPoseProvider().getPose().getX();
		float currentY = navi.getPoseProvider().getPose().getY();
		float currentHeading = navi.getPoseProvider().getPose().getHeading();
		
		float distanceX = (float) Math.cos(currentHeading * Math.PI/180) * distance;
		float distanceY = (float) Math.sin(currentHeading * Math.PI/180) * distance;

		if (distance > 0) {
			navi.goTo(currentX + distanceX, currentY + distanceY);
			if (!imediateReturn) {
				while (navi.isMoving()) {
					Thread.yield();
				}
			}
		} else {
			navi.getPoseProvider().setPose(new Pose(currentX + distanceX, currentY + distanceY, currentHeading));
			pilot.travel(distance,imediateReturn);
		}
	}
	
	protected boolean waitForStop()
	{
		if(pilot.isMoving())
		{
			return waitForPilotStop();
		}
		else if(navi.isMoving())
		{
			return waitForNaviStop();
		}
		return false;
	}
	private boolean waitForPilotStop() {
		while (pilot.isMoving()) {
			if (suppressed) {
				return true;
			}
			Thread.yield();
		}
		return false;
	}

	private boolean waitForNaviStop() {
		while (navi.isMoving()) {
			if (suppressed) {
				return true;
			}
			Thread.yield();
		}
		return false;
	}
	
	protected boolean waitForMotorStop(NXTMotor motor){
		while (motor.isMoving()){
			if (suppressed){
				return true;
			}
			Thread.yield();
		}
		return false;
	}

}
