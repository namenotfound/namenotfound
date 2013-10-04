package hsluchallange;

public class DriveToFinish extends BehaviorParent {
	
	
	
	@Override
	public void action() {
		super.action();

		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);

		navi.goTo((float) Constants.END.getX()-35, (float) Constants.END.getY()+40, 0f);
		if (waitForStop()) {
			return;
		}
		
		executed = true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DriveToFinish";
	}

}
