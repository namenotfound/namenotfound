package hsluchallange;

public class DriveTo3 extends DriveToParent {

	public DriveTo3(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}
	
	@Override
	public void action() {
		super.action();
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float)Constants.X3.getX()-2, (float)Constants.X3.getY()-2, 90.0f);
		if (waitForStop()) {
			return;
		}

		executed = true;
	}
	

}
