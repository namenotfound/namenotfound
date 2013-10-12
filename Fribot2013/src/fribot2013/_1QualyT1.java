package fribot2013;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Pose;

public class _1QualyT1 extends BehaviorParent {

	
	@Override
	public void action() {
		super.action();
		if(executed)
		{
			return;
		}
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.getPoseProvider().setPose(new Pose(25-(float)DifferentialPilot.WHEEL_SIZE_NXT1/2,120-12.5f,0));
		
		navi.goTo(80,95,-90);
		if(waitForStop())
		{
			return;			
		}
		navi.goTo(80,57,0);
		if(waitForStop())
		{
			return;			
		}
		navi.goTo(150,65,0);
		if(waitForStop())
		{
			return;			
		}
		executed=true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Qualy T1";
	}
	
	
}
