package finaltraining;

import lejos.nxt.Button;

public class Abort extends BehaviorParent {
	
	@Override
	public boolean takeControl() {
		return Button.ESCAPE.isDown();
	}
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		super.action();
		System.exit(0);
	}
	
	@Override
	public String toString() {
		return "Abort";
	}

}
