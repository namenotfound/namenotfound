package finaltraining;

import lejos.nxt.LCD;
import lejos.util.Delay;

public class Calibrate extends BehaviorParent {

	@Override
	public boolean takeControl() {
		return true;
	}

	@Override
	public void action() {
		super.action();

		//calTurn();
		
		calDist();
		
		//calColor();
		System.exit(0);
	}

	
	private void calDist()
	{
		pilot.travel(100);
	}
	
	private void calTurn()
	{
		pilot.rotate(90);
	}
	
	
	private void caliLS() {
		while (!suppressed) {
			LCD.drawInt(cs.getRawLightValue(), 0, 4);
			Delay.msDelay(500);
		}
	}

	private void calColor()
	{
		while (!suppressed) {
			LCD.drawInt(cs.getColor().getColor(), 0, 4);
			Delay.msDelay(500);
		}
	
	}
	
	@Override
	public String toString() {
		return "Calibrate";
	}

}
