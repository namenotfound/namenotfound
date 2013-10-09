package finaltraining;

import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;

public class Constants {

	private static boolean executed=false;
	
	public static DifferentialPilot PILOT;
	public static Navigator NAVI;
	public static UltrasonicSensor US;
	public static ColorSensor LIGHT;
	public static TouchSensor TS1;
	public static TouchSensor TS2;
	
	public static NXTRegulatedMotor MOTORLEFT=Motor.A;
	public static NXTRegulatedMotor MOTORMIDDLE=Motor.B;
	public static NXTRegulatedMotor MOTORRIGHT=Motor.C;
	
	public static float WHEELDIAMETEROFFSETLEFT= 0.0f;
	public static float WHEELDIAMETEROFFSETRIGHT= 0.0f;
	public static float TRACKWIDTH=10f;
	
	
	public static int DEFAULTACCELERATON=40;
	
	public static int SPEEDSLOW=5;
	public static int SPEEDMEDIUM=15;
	public static int SPEEDFAST=25;
	public static int SPEEDINSANE=40;
	
	
	public static void init()
	{
		if(!executed)
		{
			executed=true;
			initPilot();
			initNavi();
			
			//initUs();
			initLight();
			
			//initTouch1();
			//initTouch2();
		}
		
	}
	
	private static void initPilot()
	{
		PILOT =new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2+WHEELDIAMETEROFFSETLEFT, DifferentialPilot.WHEEL_SIZE_NXT2+WHEELDIAMETEROFFSETRIGHT,
				TRACKWIDTH, MOTORLEFT, MOTORRIGHT, true);
		PILOT.setAcceleration(DEFAULTACCELERATON);
	}
	private static void initNavi()
	{
		NAVI=new Navigator(PILOT);
		NAVI.getPoseProvider().setPose(new Pose(42-Constants.TRACKWIDTH/2,42,90));
	}
	private static void initUs()
	{
		US=new UltrasonicSensor(SensorPort.S4);
	}
	private static void initLight()
	{
		LIGHT=new ColorSensor(SensorPort.S3);
	}
	private static void initTouch1()
	{
		TS1=new TouchSensor(SensorPort.S1);
	}
	private static void initTouch2()
	{
		TS2=new TouchSensor(SensorPort.S2);
	}
	
	
}
