package fribot2013;

import lejos.robotics.navigation.Pose;

public class _1QualyT1 extends BehaviorParent {

	
	@Override
	public void action() {
		super.action();
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.getPoseProvider().setPose(new Pose(25,12.5f,0));
		
		navi.goTo(90,20,-90);
		if(waitForStop())
		{
			return;			
		}
		navi.goTo(90,65,0);
		if(waitForStop())
		{
			return;			
		}
		navi.goTo(150,65,0);
		if(waitForStop())
		{
			return;			
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Qualy T1";
	}
	
	
}
