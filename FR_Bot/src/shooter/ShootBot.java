package shooter;


import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.Color;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class ShootBot {

	private Arbitrator arbi;
	private DifferentialPilot pilot;
	
	
	public ShootBot()
	{
		initPilot();
		
		Touch t=new Touch(pilot);
		
		Behavior[] bev={new Forward(pilot),t,new GoHome(pilot, t),
				//,new Calibrate(pilot)
		new Abort(pilot)
		};
		
		arbi=new Arbitrator(bev);
		
	}
	
	public void run()
	{
		Delay.msDelay(1000);
		arbi.start();
	}
	
	
	private void initPilot()
	{
		pilot=new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2+Constants.wheelSizeCorrecture, Constants.trackwidth, Constants.motorLeft,Constants.motorRight,false);
	}
	
	public static void main(String[] args)
	{
		LCD.drawString("Move Bot", 0, 0);
		Button.waitForAnyPress();
		ShootBot mb=new ShootBot();
		mb.run();
	}
}
