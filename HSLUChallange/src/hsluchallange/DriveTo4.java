package hsluchallange;

public class DriveTo4 extends DriveToParent {

	public DriveTo4(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	} 

	@Override
	public void action() {
		super.action();

		cd.setActive(true);

		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);

		pilot.travel(-10);
		if (waitForStop()) {
			return;
		}

		navi.goTo((float) Constants.X4.getX() + 15, (float) Constants.X4.getY(), 180f);
		if (waitForStop()) {
			return;
		}

		cd.setActive(false);
		db.enable();

		executed = true;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DriveTo4";
	}

}
