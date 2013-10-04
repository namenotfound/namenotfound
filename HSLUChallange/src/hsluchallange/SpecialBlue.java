package hsluchallange;

public class SpecialBlue extends DriveToParent {

	public SpecialBlue(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}
	
	@Override
	public void action() {
		super.action();
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float)Constants.X5.getX()-2, (float)Constants.X5.getY()-2, 90.0f);
		if (waitForStop()) {
			return;
		}

		executed = true;
	}

}
