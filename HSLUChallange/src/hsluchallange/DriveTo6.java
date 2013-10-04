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

		navi.goTo((float) Constants.X6.getX()-5, (float) Constants.X6.getY()+10,
				-70f);
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
