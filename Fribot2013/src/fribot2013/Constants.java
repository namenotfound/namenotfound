package fribot2013;


import java.awt.Point;

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
	public static LightSensor LIGHT;
	public static LightSensor LIGHTHOR;
	public static UltrasonicSensor US;
	
	public static float TRACKWIDTH=12f;
	public static float WHEELDIAMETEROFFSET=-0.11f;
	public static NXTRegulatedMotor MOTORLEFT=Motor.A;
	public static NXTRegulatedMotor MOTORRIGHT=Motor.C;
	public static NXTRegulatedMotor MOTORMIDDLE=Motor.B;
	
	public static int ACCELERATION=40;
	
	public static int SPEEDTOUCH=4;
	public static int SPEEDSLOW=8;
	public static int SPEEDMEDIUM=25;
	public static int SPEEDFAST=25;
	public static int SPEEDINSANE=60;

	//X5,X3,X6,X4    X2,X1 End
	public static Point START =new Point(57,20+(int)(TRACKWIDTH/2));
	public static Point X1=new Point(262,48);
	public static Point X2=new Point(225,120);
	public static Point X3=new Point(150,120);
	public static Point X4=new Point(43,156);
	public static Point X5=new Point(150,84);
	public static Point X6=new Point(74,84);
	public static Point END=new Point(300,158);
	
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
		NAVI.getPoseProvider().setPose(new Pose(54, 27,0));
	}
	private static void initUS()
	{
	US=new UltrasonicSensor(SensorPort.S4);
	}
	private static void initLight()
	{
		LIGHT=new LightSensor(SensorPort.S3);
		LIGHTHOR=new LightSensor(SensorPort.S2);
	}
	private static void initTouch()
	{
		TS1=new TouchSensor(SensorPort.S1);
		TS2=new TouchSensor(SensorPort.S2);
	}
}
