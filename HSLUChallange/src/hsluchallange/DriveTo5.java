package hsluchallange;

public class DriveTo5 extends DriveToParent {

	public DriveTo5(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}
	
	@Override
	public void action() {
		super.action();
		
		cd.setActive(true);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo((float)Constants.X5.getX(), (float)Constants.X5.getY()-15, 90.0f);
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
		return "DriveTo5";
	}

}
