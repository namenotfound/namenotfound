import lejos.hardware.Button;


public class Abort extends BehaviorParent {

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return Button.ENTER.isDown();
	}
	
	@Override
	public void action() {
		System.exit(0);
	}

}
