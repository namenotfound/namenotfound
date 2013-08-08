package fribot2009;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;

public class Fribot2009 {

	private Arbitrator arbi;
	private DifferentialPilot pilot;
	private Navigator navi;
	
	public Fribot2009()
	{
		initPilot();
		initNavi();
		
		Behavior[] bev={new GotoFinish(pilot, navi),new PlaceStilo(pilot, navi),new PlaceStilo(pilot, navi),new SearchSlot(pilot, navi)
	//	,new Calibrate(pilot, navi)
		,new Abort(pilot, navi)
		};
		arbi=new Arbitrator(bev);
		
	}
	
	private void initPilot()
	{
		pilot=new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2+Constants.wheelDiameterOffset, Constants.trackWidth, Constants.motorLeft, Constants.motorRight);
	}
	private void initNavi()
	{
		navi=new Navigator(pilot);
		navi.getPoseProvider().setPose(new Pose(0, 0, 0));
	}
	
	
	
	public void run()
	{
		Delay.msDelay(1000);
		arbi.start();
	}
	
	public static void main(String[] args)
	{
		LCD.drawString("Fribot 2009", 0, 0);
		Button.waitForAnyPress();
	}
}
