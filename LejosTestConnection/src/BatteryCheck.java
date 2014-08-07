import lejos.hardware.Battery;
import lejos.hardware.lcd.LCD;
import lejos.utility.Delay;

public class BatteryCheck extends Thread {

	private boolean useLoop = true;

	public boolean isUseLoop() {
		return useLoop;
	}

	public void setUseLoop(boolean useLoop) {
		this.useLoop = useLoop;
	}

	@Override
	public void run() {
		do {
			float volt = Battery.getVoltage();
			LCD.drawString(String.valueOf(volt) + " V", 8, 7);
			Delay.msDelay(3000);
		} while (useLoop);
	}

}
