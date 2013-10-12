package fribot2013;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Pose;
import lejos.util.Delay;
import lejos.util.PIDController;

public class _2LightEnenmy extends BehaviorParent {

	
	private int stopDistance=10;
	
	@Override
	public void action() {
		super.action();
		if(executed)
		{
			return;
		}
		
		pilot.setAcceleration(Constants.ACCELERATION);
		//navi.goTo(178,95,90);
	//	if(waitForStop())
		//{	
			//return;
		//}
		
		pilot.setAcceleration(300);
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		
		us.continuous();
	
		while(!supressed&&(us.getRange()>stopDistance))
		{
			doPID(-1);
		}
		pilot.stop();
		navi.getPoseProvider().setPose(new Pose(180,119-stopDistance,90));
		pilot.setAcceleration(Constants.ACCELERATION);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		pilot.travel(stopDistance-5f);
		Delay.msDelay(100);	
		pilot.travel(-(stopDistance+2));	
		
		
		
		executed=true;
	}
	

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Light Enemy";
	}
	
}
