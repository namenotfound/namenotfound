package hsluchallange;

public class DriveTo4 extends DriveToParent {

	public DriveTo4(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}
	
	@Override
	public void action() {
		super.action();
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float)Constants.X4.getX()-2, (float)Constants.X4.getY()-2, 90.0f);
		if (waitForStop()) {
			return;
		}

		executed = true;
	}

}
