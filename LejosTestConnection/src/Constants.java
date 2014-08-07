import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;


public abstract class Constants {

	private static boolean initialised=false;
	
	public static Navigator NAVI;
	public static DifferentialPilot PILOT;
	public static EV3TouchSensor TOUCH1;
	public static EV3TouchSensor TOUCH2;
	public static EV3ColorSensor COLOR;
	public static EV3UltrasonicSensor US;
	
	public static float TRACKWIDTH=21.4f;
	public static float WHEELDIAMETEROFFSET=-1.5f;
	public static RegulatedMotor MOTORLEFT=new EV3LargeRegulatedMotor(MotorPort.A);
	public static RegulatedMotor MOTORRIGHT=new EV3LargeRegulatedMotor(MotorPort.B);
	public static RegulatedMotor MOTORMIDDLE=new EV3MediumRegulatedMotor(MotorPort.C);
	
	public static int ACCELERATION=2;
	public static int SPEEDTOUCH=4;
	public static int SPEEDSLOW=8;
	public static int SPEEDMEDIUM=25;
	public static int SPEEDFAST=40;
	public static int SPEEDINSANE=90;
	
	public static void init()
	{
		if(!initialised){
			initPilot();
			initNavigation();
			initColor();
			initUs();	
			initTouch();
			
			initialised=true;
		}
		
	}
	
	private static void initPilot()
	{
		PILOT=new DifferentialPilot(PILOT.WHEEL_SIZE_NXT1+WHEELDIAMETEROFFSET, TRACKWIDTH, MOTORLEFT, MOTORRIGHT);
		PILOT.setAcceleration(ACCELERATION);
	}
	
	private static void initNavigation()
	{
		NAVI=new Navigator(PILOT);
	}
	
	private static void initTouch(){
		TOUCH1=new EV3TouchSensor(LocalEV3.get().getPort("S1"));
	//	TOUCH2=new EV3TouchSensor(LocalEV3.get().getPort("S2"));
	}
	
	private static void initColor()
	{	
		COLOR=new EV3ColorSensor(LocalEV3.get().getPort("S3"));
	}
	
	private static void initUs()
	{
		US=new EV3UltrasonicSensor(LocalEV3.get().getPort("S4"));
	}
	
}
