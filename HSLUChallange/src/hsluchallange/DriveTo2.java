package hsluchallange;

public class DriveTo2 extends DriveToParent {
		
	public DriveTo2(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}

	@Override
	public void action() {
		super.action();
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float)Constants.X2.getX()-2, (float)Constants.X2.getY()-2, 90.0f);
		if (waitForStop()) {
			return;
		}

		executed = true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DriveTo2";
	}

}
