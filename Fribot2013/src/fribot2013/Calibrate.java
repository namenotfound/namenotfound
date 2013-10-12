package fribot2013;

import lejos.nxt.ColorSensor.Color;
import lejos.nxt.LCD;
import lejos.robotics.navigation.Waypoint;
import lejos.util.Delay;

public class Calibrate extends BehaviorParent {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		super.action();

		// calOdometry();
		// calLight();
		calLight();
		//calcTurn();
		//calcDist();
		//calcMiddle();
		executed = true;

	}

	
	private void calcTurn()
	{
		pilot.rotate(90);
	}
	
	private void calcDist()
	{
		
		pilot.travel(30);
	}
	
	private void calcMiddle()
	{
		Constants.MOTORMIDDLE.setAcceleration(900);
		Constants.MOTORMIDDLE.rotate(200);
		Constants.MOTORMIDDLE.rotate(-200,true);
	}
	
	
	private void calLight() {
		// RED = 0, BLUE = 2
		light.setFloodlight(false);
		
		while (!supressed) {
			
		
			int c1 = light.getNormalizedLightValue();
			LCD.clear(2);
			LCD.drawInt(c1, 3, 0, 2);
			Delay.msDelay(100);

		}

	}

	private void calOdometry() {
		LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
		pilot.travel(30);
		waitForStop();
		LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
		pilot.rotate(90);
		waitForStop();
		LCD.drawString(navi.getPoseProvider().getPose().toString() + "", 0, 2);

		navi.goTo(0, 0, 0);
		LCD.drawString(navi.getPoseProvider().getPose().toString() + "", 0, 2);
	}

	private void calTurn() {
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		// pilot.forward();

		// Delay.msDelay(1000);

		pilot.steer(60);

		for (int i = 0; i < 10; i++) {
			Delay.msDelay(500);
			LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
			LCD.drawString(navi.getPoseProvider().getPose().getHeading() + "",
					0, 3);
		}
		pilot.stop();
		// pilot.steer(-60);

		Delay.msDelay(2000);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Calibrate";
	}

}
