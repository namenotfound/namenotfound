import lejos.hardware.Battery;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.utility.Delay;

public class Main {

	public static void main(String[] args) {

		LCD.drawString("Initialising", 0, 0);
		Constants.init();
		LCD.drawString("Test Challange", 0, 0);
		// Button.waitForAnyPress();

		Behavior[] behaviors = {new _5_FindObject(),new _6_LineSearch(),new _7_ReleaseCargo(),
				new Callibration(), new Abort() };

		Arbitrator arbi = new Arbitrator(behaviors);

		/*BatteryCheck bc = new BatteryCheck();
		bc.setDaemon(true);
		bc.setUseLoop(false);
		bc.start();*/
		
		float volt = Battery.getVoltage();
		LCD.drawString(String.valueOf(volt) + " V", 8, 7);
		Delay.msDelay(3000);

		arbi.start();

	}

}
