package hsluchallange;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class HSLUChallange {

	
	public static void main(String[] args)
	{
		LCD.drawString("HSLU Challange", 0, 0);
		Button.waitForAnyPress();
		Delay.msDelay(500);
		Constants.init();
		CollisionDetect cd=new CollisionDetect();
		SpecialBlue sb=null;
		DestroyBalloon db=new DestroyBalloon(sb);
		sb=new SpecialBlue(db, cd);
		Behavior[] behavior={
				new DriveToFinish(),
				//new DriveToStart(),
				new DriveTo4(db, cd),new DriveTo6(db, cd),
					new DriveTo3(db, cd),					
					new DriveTo5(db, cd),
					db,
					cd,
				//new Calibrate(),
				new Abort()
		};
		
		
		Arbitrator arbi=new Arbitrator(behavior);
		
		arbi.start();
		
	}
	
	
	
}
