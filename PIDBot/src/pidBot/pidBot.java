package pidBot;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class pidBot {

	
	public static void main(String[] args)
	{
		LCD.drawString("PID Bot", 0, 0);
		Button.waitForAnyPress();
		Delay.msDelay(1000);
		Constants.init();
		Behavior[] behavior={
				new Calibrate(),
				new Abort()
		};
		
		
		Arbitrator arbi=new Arbitrator(behavior);
		
		arbi.start();
		
	}
	
	
	
}
