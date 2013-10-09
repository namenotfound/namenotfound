package finaltraining;

import lejos.nxt.Button;

public class Abort extends BehaviorParent {
	
	@Override
	public boolean takeControl() {
		return Button.ESCAPE.isDown();
	}
	
	@Override
	public String toString() {
		return "Abort";
	}

}
