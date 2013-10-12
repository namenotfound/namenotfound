package fribot2013;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class Fribot2013 {

	
	public static void main(String[] args)
	{
		LCD.drawString("Fribot 2013", 0, 0);
		Button.waitForAnyPress();
		Delay.msDelay(1000);
		Constants.init();
		//new Calibrate().action();
		new _1QualyT1().action();
		new _2LightEnenmy().action();
		new _3GrabBall().action();
		new _4LightOur().action();
		new _5ThrowBall().action();
	
	
		
	
	/*	Behavior[] behavior={
				new _5ThrowBall(),
				new _4LightOur(),
				new _3GrabBall(),
				new _2LightEnenmy(),
				new _1QualyT1(),
				//new Calibrate(),
				new Abort()
		};*/
		
		
		//Arbitrator arbi=new Arbitrator(behavior);
		
	//	arbi.start();
		
	}
	
}
