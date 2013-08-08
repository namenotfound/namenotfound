package shooter;


import lejos.nxt.Button;
import lejos.robotics.navigation.DifferentialPilot;

public class Abort extends BehaviorParent{

	public Abort(DifferentialPilot pilot) {
		super(pilot);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean takeControl() {
		if(Button.ESCAPE.isDown())
		{
			return true;
		}
		return false;
	}
	
	
	@Override
	public void action() {
		super.action();
		System.exit(0);
	}
	
	
}
