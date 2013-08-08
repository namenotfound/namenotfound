package MoveBot;

import lejos.nxt.Button;
import lejos.nxt.ColorSensor;
import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;
import lejos.util.Delay;

public class Calibrate extends BehaviorParent{

	
	ColorSensor cs;
	Navigator navi;
	
	public Calibrate(DifferentialPilot pilot) {
		super(pilot);
		cs=new ColorSensor(SensorPort.S3);
		navi=new Navigator(pilot);
	}
	
	
	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void action() {
		super.action();
		//CalColorSensor();
		//CalCentralMotor();
		CalNavi();
		System.exit(0);
	}
	
	private void CalCentralMotor()
	{
		Constants.motorCentral.setSpeed(Constants.centralMotorSpeed);
		Constants.motorCentral.rotate(Constants.centralMotorDist);
		Button.waitForAnyPress();
		Constants.motorCentral.rotate(-Constants.centralMotorDist);
	}
	private void CalColorSensor()
	{
		while(!Button.ESCAPE.isDown())
		{
			LCD.clear(3);
			LCD.clear(4);
		LCD.drawInt(cs.getColor().getRed(),3, 0, 3);
		LCD.drawInt(cs.getColor().getGreen(),3, 5, 3);
		LCD.drawInt(cs.getColor().getBlue(),3, 10, 3);
		LCD.drawString(String.valueOf(cs.getColor().getColor()), 0, 4);
		Delay.msDelay(500);
		}
	}
	
	
	private void CalNavi()
	{
		rotate(180,false);
	//	waitForStop();
	//	travel(10,false);
	
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Callibrating...";
	}
	

}
