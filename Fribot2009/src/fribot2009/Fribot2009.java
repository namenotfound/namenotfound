package fribot2009;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
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
	private UltrasonicSensor us;
	private ColorSensor cs;
	private TouchSensor ts1;
	private TouchSensor ts2;
	
	public Fribot2009()
	{
		initPilot();
		initNavi();
		initSensors();
		Behavior[] bev={new GotoFinish(pilot, navi, us, cs, ts1, ts2),new PlaceStilo(pilot, navi, us, cs, ts1, ts2),new PushObject(pilot, navi, us, cs, ts1, ts2),new SearchSlot(pilot, navi, us, cs, ts1, ts2)
	 //  ,new Calibrate(pilot, navi, us, cs, ts1, ts2)
		,new Abort(pilot, navi, us, cs, ts1, ts2)
		};
		arbi=new Arbitrator(bev);
		
	}
	
	private void initPilot()
	{
		pilot=new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2+Constants.wheelDiameterOffset, Constants.trackWidth, Constants.motorLeft, Constants.motorRight);
	pilot.setAcceleration(40);
	}
	private void initNavi()
	{
		navi=new Navigator(pilot);
		navi.getPoseProvider().setPose(new Pose(34.5f, 27, 0));
	}
	private void initSensors()
	{
		us=new UltrasonicSensor(SensorPort.S4);
		cs=new ColorSensor(SensorPort.S3);
		ts1=new TouchSensor(SensorPort.S1);
		ts2=new TouchSensor(SensorPort.S2);
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
		Fribot2009 f9=new Fribot2009();
		f9.run();
	}
}
