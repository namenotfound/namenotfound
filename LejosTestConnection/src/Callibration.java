import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.SensorMode;
import lejos.robotics.Color;
import lejos.utility.Delay;


public class Callibration extends BehaviorParent {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void action() {
		initBehavior();
	//	callibrateDIstance();
	//	callibrateTurn();
	//	callibrateMiddle();
		ColorTest();
		System.exit(0);
	}

	
	private void callibrateTurn()
	{
		pilot.rotate(180);
		pilot.rotate(180);
		pilot.rotate(180);

	}
	
	private void callibrateDIstance(){
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		pilot.travel(100);
	}
	
	private void ColorTest() {

		SensorMode lightMode=Constants.COLOR.getRedMode();
		while (!suppressed) {			
			float[] values=new float[lightMode.sampleSize()];
			lightMode.fetchSample(values, 0);
			LCD.clear(3);
			LCD.drawString(String.valueOf((values[0]*100)),0,3);
			Delay.msDelay(500);
		}
		
	}
	
	private void callibrateMiddle(){
		Constants.MOTORMIDDLE.setAcceleration(720);
		Constants.MOTORMIDDLE.setSpeed(720);
		Constants.MOTORMIDDLE.rotate(80);
		Button.waitForAnyPress();
		Constants.MOTORMIDDLE.rotate(-100);
	}
	
	@Override
	public String toString() {
		return "Callibration";
	}
	
}
