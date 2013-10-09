package finaltraining;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class FinalTraining {

	
	
	public static void main(String[] args)
	{
		LCD.drawString("FINAL Training", 0, 0);
		Button.waitForAnyPress();
		Delay.msDelay(1000);
		Constants.init();
		_3PickBall pb=new _3PickBall();
		Behavior[] b={
				new _5DriveHome(pb),
				new _4GetBall(),
				new _3PickBall(),
				new _2_Linefollower(),
				new _1DriveToLine(),
				
				//new Calibrate(),
				new Abort()
		};
		
		Arbitrator arbi=new Arbitrator(b);
		arbi.start();
		
		
	}
	
	
}
