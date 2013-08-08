package fribot2009;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Navigator;

public class SearchSlot extends BehaviorParent {

	public SearchSlot(DifferentialPilot pilot, Navigator navi) {
		super(pilot, navi);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void action() {
		super.action();
		navi.goTo(0, 0, -90);
		if(waitForStop())
		{
			return;
		}
		if(search())
		{
			return;
		}
		
	}

	
	private boolean search()
	{
		
		
		return false;
	}
	
	
}
