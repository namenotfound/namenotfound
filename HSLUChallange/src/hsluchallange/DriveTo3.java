package hsluchallange;

import fribot2013.Constants;

public class DriveTo3 extends DriveToParent {

	public DriveTo3(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}

	@Override
	public void action() {
		super.action();

		cd.setActive(true);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		pilot.rotate(90);
		pilot.travel(20);
		if (waitForStop()) {
			return;
		}

		navi.goTo((float) Constants.X3.getX() - 30, (float) Constants.X3.getY(), 0f);
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
