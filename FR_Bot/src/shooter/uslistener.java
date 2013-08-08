package shooter;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class uslistener extends BehaviorParent {

	
	
	UltrasonicSensor us;
	public uslistener(DifferentialPilot pilot) {
		super(pilot);
		// TODO Auto-generated constructor stub
		us=new UltrasonicSensor(SensorPort.S4);
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void action() {
		
		super.action();
		us.capture();
		while(!supressed)
		{
			LCD.clear(1);
			LCD.drawString("Dist :",0, 1);
			LCD.drawInt(us.getDistance(), 2, 7,1);
			Delay.msDelay(250);
		}
	}

	
	
}
