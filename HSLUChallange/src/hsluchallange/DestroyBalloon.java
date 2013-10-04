package hsluchallange;

import java.util.ArrayList;

import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.robotics.Color;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;

public class DestroyBalloon extends BehaviorParent {

	private int executions = 0;
	private int hitDistanze = 12;
	private boolean canExecute = true;

	SpecialBlue sbBlue;

	public DestroyBalloon(SpecialBlue sBlue) {
		this.sbBlue = sBlue;
		executed = true;
	}

	public void enable() {
		if (canExecute) {
			executed = false;
		}
	}

	@Override
	public void action() {
		super.action();
		executed = true;
		us.continuous();
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		//int range=findNearObject();
		adjust(40, 1, false);
		pilot.forward();
	
		Pose p = navi.getPoseProvider().getPose();
		while (us.getRange() > hitDistanze+(executions==0?-1:0)) {
			Delay.msDelay(100);
			Pose p2 = navi.getPoseProvider().getPose();
			int delta = (int) Math.abs(p2.getX() - p.getX());
			delta += (int) Math.abs(p2.getY() - p.getY());
			if (delta > 50) {
				pilot.stop();
				//executed = true;
				pilot.travel(-6);
				Constants.MOTORMIDDLE.setAcceleration(900);
				Constants.MOTORMIDDLE.rotate(210);
				Constants.MOTORMIDDLE.rotate(-210);
				return;
			}
		}
		pilot.stop();
		executions++;
		Color color = light.getColor();
		LCD.drawInt(color.getBlue(), 0, 4);
		LCD.drawInt(color.getRed(), 0, 5);
		if (color.getBlue() >= 6 &&color.getRed()<20) {
		//	LCD.drawString("BLUE", 0, 4);
			// if (executions == 1) {

			// sbBlue.setExecuted(true);
			// executed = true;
			// return;
			// }
			canExecute = false;
		}
		Constants.MOTORMIDDLE.setAcceleration(900);
		Constants.MOTORMIDDLE.rotate(210);
		Constants.MOTORMIDDLE.rotate(-210);
		pilot.travel(-(25 - hitDistanze));
		
	}

	private int findNearObject() {
		int min = 255;
		int temp = 0;
		for(int u=0;u<2;u++)
		{
		for (int i = 0; i < (10*u+1); i++) {
			pilot.rotate(5 * u==0?1:-1, true);
			temp = (int) us.getRange();
			if (temp < min) {
				min = temp;
			}
			Delay.msDelay(200);
		}
		}
		return min;
	}

	private int adjust(int range, int dir, boolean gotBEtter) {
		pilot.rotate(5 * dir, true);
		Delay.msDelay(100);
		int tmprng = (int) us.getRange();
		if (tmprng > range) {
			dir *= -1;
			if (gotBEtter) {
				pilot.rotate(13 * dir, false);
				return (int) us.getRange();
			}
		} else {
			gotBEtter = true;
		}
		range = tmprng;
		return adjust(range, dir, gotBEtter);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Destroy";
	}
}
