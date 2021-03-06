package pidBot;

import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.robotics.navigation.Pose;

public class Constants {

	private static boolean initialised=false;
	
	public static Navigator NAVI;
	public static DifferentialPilot PILOT;
	public static TouchSensor TS1;
	public static TouchSensor TS2;
	public static ColorSensor LIGHT;
	public static UltrasonicSensor US;
	
	public static float TRACKWIDTH=17.2f;
	public static float WHEELDIAMETEROFFSET=-0.1f;
	public static NXTRegulatedMotor MOTORLEFT=Motor.A;
	public static NXTRegulatedMotor MOTORRIGHT=Motor.C;
	public static NXTRegulatedMotor MOTORMIDDLE=Motor.B;
	
	public static int ACCELERATION=40;
	
	public static int SPEEDTOUCH=4;
	public static int SPEEDSLOW=8;
	public static int SPEEDMEDIUM=16;
	public static int SPEEDFAST=25;
	public static int SPEEDINSANE=60;

	public static void init()
	{
	if(!initialised)
	{
		initPilot();
		initNavigation();
		
	//	initTouch();
		initLight();
	//	initUS();		
		initialised=true;
	}
	}
	
	private static void initPilot()
	{
		PILOT=new DifferentialPilot(DifferentialPilot.WHEEL_SIZE_NXT2+WHEELDIAMETEROFFSET, TRACKWIDTH, MOTORLEFT, MOTORRIGHT);
		PILOT.setAcceleration(ACCELERATION);
	}
	
	private static void initNavigation()
	{
		NAVI=new Navigator(PILOT);
		NAVI.getPoseProvider().setPose(new Pose(0, 0,0));
	}
	private static void initUS()
	{
	US=new UltrasonicSensor(SensorPort.S4);
	}
	private static void initLight()
	{
		LIGHT=new ColorSensor(SensorPort.S3);
	}
	private static void initTouch()
	{
		TS1=new TouchSensor(SensorPort.S1);
		TS2=new TouchSensor(SensorPort.S2);
	}
}
