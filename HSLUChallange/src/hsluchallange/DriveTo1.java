package hsluchallange;

import fribot2013.Constants;

public class DriveTo1 extends DriveToParent {

	public DriveTo1(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void action() {
		super.action();
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float)Constants.X1.getX(), (float)Constants.X2.getY()-15, -90.0f);
		if (waitForStop()) {
			return;
		}

		executed = true;
	}
	 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DriveTo1";
	}

}
