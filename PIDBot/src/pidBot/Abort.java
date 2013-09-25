package pidBot;

import lejos.nxt.Button;

public class Abort extends BehaviorParent {

	public boolean takeControl(){
		return Button.ESCAPE.isDown();
	}
	
	public void action(){
		super.action();
		System.exit(0);
	}
	
}
