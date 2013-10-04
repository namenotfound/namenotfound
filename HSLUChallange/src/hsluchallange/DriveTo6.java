package hsluchallange;

public class DriveTo6 extends DriveToParent {

	public DriveTo6(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	} 

	@Override
	public void action() {
		super.action();
		
		cd.setActive(true);

		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float) Constants.X6.getX(), (float) Constants.X3.getY(), 180f);
		if (waitForStop()) {
			return;
		}

		navi.goTo((float) Constants.X6.getX(), (float) Constants.X3.getY(),
				-90f);
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
		return "DriveTo6";
	}

}
