package hsluchallange;

public class DriveToFinish extends BehaviorParent {
	
	
	
	@Override
	public void action() {
		super.action();

		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);

		navi.goTo((float) Constants.END.getX()-20, (float) Constants.END.getY(), 90f);
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
