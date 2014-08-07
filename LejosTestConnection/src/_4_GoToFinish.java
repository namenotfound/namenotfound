import lejos.robotics.navigation.Pose;


public class _4_GoToFinish extends BehaviorParent {

	@Override
	public void action() {
		executed=true;
		initBehavior();
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		
		navi.goTo(20.5f, 24.5f, 0);
		if(waitFOrStop())
		{
			return;
		}		
		System.exit(0);
	}

	
	@Override
	public String toString() {
		return "Goto Finish";
	}
}
