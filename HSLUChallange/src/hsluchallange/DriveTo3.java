package hsluchallange;

public class DriveTo3 extends DriveToParent {

	public DriveTo3(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}

	@Override
	public void action() {
		super.action();

		cd.setActive(true);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo(105f, 70.0f, 45);
		if (waitForStop()) {
			return;
		}

		navi.goTo(105f, (float) Constants.X3.getY(), 90f);
		if (waitForStop()) {
			return;
		}

		navi.goTo(105f, (float) Constants.X3.getY(), 0f);
		if (waitForStop()) {
			return;
		}

		navi.goTo((float) Constants.X3.getX() - 15,
				(float) Constants.X3.getY(), 0f);
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
		return "DriveTo3";
	}

}
