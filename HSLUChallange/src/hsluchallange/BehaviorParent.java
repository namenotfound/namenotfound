package hsluchallange;


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

public abstract class BehaviorParent implements Behavior {

	protected boolean supressed=false;
	protected boolean executed=false;
	protected DifferentialPilot pilot=Constants.PILOT;
	protected Navigator navi=Constants.NAVI;
	protected TouchSensor ts1=Constants.TS1;
	protected TouchSensor ts2=Constants.TS2;
	protected UltrasonicSensor us=Constants.US;
	protected ColorSensor light=Constants.LIGHT;
	
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return !executed;
	}
	
	@Override
	public void action() {
		supressed=false;
		LCD.clear(2);
		LCD.drawString(this.toString(), 0, 1);
		Sound.playTone(2500, 500);
	}

	@Override
	public void suppress() {
		supressed=true;
		
	}

	protected boolean waitForStop()
	{
		if(navi.isMoving())
		{
			return waitForNaviStop();
		}
		if(pilot.isMoving())
		{
			return waitForPilotStop();
		}
		return true;
	}
	private boolean waitForNaviStop()
	{
		while(navi.isMoving())
		{
			if(supressed)
			{
				return false;
			}
			Thread.yield();
		}
		return true;
	}
	private boolean waitForPilotStop()
	{
		while(pilot.isMoving())
		{
			if(supressed)
			{
				return false;
			}
			Thread.yield();
		}
		return true;
	}
	
	
}
