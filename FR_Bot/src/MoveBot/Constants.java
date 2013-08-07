package MoveBot;

import java.util.Random;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

public abstract class Constants {

	public static final int speedSlow=10;
	public static final int speedNormal=16;
	public static final int speedFast=35;
	
	public static final float trackwidth=12.8f;
	public static final double wheelSizeCorrecture=0f;
	
	public static final NXTRegulatedMotor motorLeft=Motor.C;
	public static final NXTRegulatedMotor motorRight=Motor.A;
	public static final NXTRegulatedMotor motorCentral=Motor.B;
	
	public static final Random cRand=new Random();
	
	public static final int centralMotorDist=235;
	public static final int centralMotorSpeed=320;
	
}
