package hsluchallange;

public class DriveTo6 extends DriveToParent {

	public DriveTo6(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}
	
	@Override
	public void action() {
		super.action();
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float)Constants.X6.getX()-2, (float)Constants.X6.getY()-2, 90.0f);
		if (waitForStop()) {
			return;
		}

		executed = true;
	}

}
