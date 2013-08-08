package fribot2009;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

public class Constants {

	public static final NXTRegulatedMotor motorLeft=Motor.A;
	public static final NXTRegulatedMotor motorRight=Motor.C;
	public static final NXTRegulatedMotor motorCentral=Motor.B;
	
	public static final int speedSlow=8;
	public static final int speedMedium=16;
	public static final int speedFast=25;
	
	public static final int motorCentralRotVal=100;
	public static final int motorCentralSpeed=360;
	
	public static final float trackWidth=17f;
	public static final double wheelDiameterOffset=-0.1f;
	
	
}
