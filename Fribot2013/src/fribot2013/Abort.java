package fribot2013;


import lejos.nxt.Button;

public class Abort extends BehaviorParent {

	public boolean takeControl(){
		return Button.ESCAPE.isDown();
	}
	
	public void action(){
		super.action();
		System.exit(0);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Aborting Program";
	}
	
}
