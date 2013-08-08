package fribot2009;

import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.Color;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.util.Delay;

public class PlaceStilo extends BehaviorParent {

	public PlaceStilo(DifferentialPilot pilot, Navigator navi, UltrasonicSensor us, ColorSensor cs, TouchSensor ts1, TouchSensor ts2) {
		super(pilot, navi, us,cs,ts1,ts2);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void action() {
		super.action();
		pilot.setTravelSpeed(Constants.speedMedium);
		travel(200,true);
		while(cs.getColor().getColor()!=Color.BLACK)
		{
			LCD.drawInt(cs.getColor().getColor(), 2, 0, 2);
			
			LCD.drawInt(cs.getColor().getRed(), 3, 0, 4);
			LCD.drawInt(cs.getColor().getGreen(), 3, 5, 4);
			LCD.drawInt(cs.getColor().getBlue(), 3, 10, 4);
			if(suppressed)
			{
				navi.stop();
				navi.clearPath();
				return;
			}
			Thread.yield();
		}
		navi.stop();
		navi.clearPath();
		rotate(-70, true);
		if(waitForStop())
		{
			return;
		}
		int rotfactor=-1;
		while(!ts1.isPressed()&&!ts2.isPressed())
		{
			if(cs.getColor().getColor()!=Color.BLACK)
			{
				navi.stop();
				navi.clearPath();
				int max=3;
				while(cs.getColor().getColor()!=Color.BLACK)
				{
					pilot.setTravelSpeed(Constants.speedTouch);
					rotate(rotfactor* 5*max, true);
					while(navi.isMoving()&&cs.getColor().getColor()!=Color.BLACK)
					{
						if(suppressed)
						{
							navi.stop();
							navi.clearPath();
							return;
						}
						Delay.usDelay(500);
					}
					navi.stop();
					navi.clearPath();
						max+=9;
						rotfactor*=-1;
				}
				pilot.setTravelSpeed(Constants.speedSlow);
				travel(100,true);
			}if(suppressed)
			{
				navi.stop();
				navi.clearPath();
			}
		}
		navi.stop();
		navi.clearPath();
		pilot.setTravelSpeed(Constants.speedFast);
		travel(-10,true);
		if(waitForStop())
		{
			return;
		}
		Constants.motorCentral.setSpeed(Constants.motorCentralSpeed);
		Constants.motorCentral.rotate(Constants.motorCentralRotVal,true);
		if(waitForMotorStop(Constants.motorCentral))
		{
			return;
		}
		Constants.motorCentral.rotate(-Constants.motorCentralRotVal-105,true);
		if(waitForMotorStop(Constants.motorCentral))
		{
			return;
		}
		travel(-30,true);
		if(waitForStop())
		{
			return;
		}
		executed=true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Place Stilo";
	}
	
}
