package MoveBot;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.Color;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class MoveBot {

	private Arbitrator arbi;
	private DifferentialPilot pilot;
	
	
	public MoveBot()
	{
		initPilot();
		
		Delay.msDelay(1000);
		int color=0;
		while(!Button.ENTER.isDown())
		{
			if(color==0)
			{
				LCD.drawString("Dropoff: RED", 0, 2);
			}
			else if(color==1)
			{
				LCD.drawString("Dropoff: Blue", 0, 2);
			}
			if(Button.LEFT.isDown())
			{
				while(!Button.LEFT.isUp())
				{
					Delay.msDelay(10);
				}
				color--;
			}
			if(Button.RIGHT.isDown())
			{
				while(!Button.RIGHT.isUp())
				{
					Delay.msDelay(10);
				}
				color--;
			}
			if(color<0)
			{
				color=1;
			}
			if(color>1)
			{
				color=0;
			}
			Delay.msDelay(10);
		}
		
		if(color==1)
		{
			color=Color.BLUE;
		}
		
		
		Behavior[] bev={new GoHome(pilot),new DropOffObject(pilot),new SearchDropoffArea(pilot,color),
				new GoToDropOff(pilot,color),new PickUpObject(pilot),new SearchObject(pilot),new GoToPickup(pilot)
				//,new Calibrate(pilot)
		,new Abort(pilot)
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
		MoveBot mb=new MoveBot();
		mb.run();
	}
}
