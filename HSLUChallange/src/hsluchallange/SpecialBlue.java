package hsluchallange;

public class SpecialBlue extends DriveToParent {

	private int executions=0;
	
	public SpecialBlue(DestroyBalloon db, CollisionDetect cd) {
		super(db, cd);
	}
	
	@Override
	public void action() {
		super.action();
		cd.setActive(true);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		if(executions==0)
		{
		navi.goTo((float)Constants.X5.getX()-15, (float)Constants.X5.getY(), 0.0f);
		}
		else{
			navi.goTo((float)Constants.X3.getX()-15, (float)Constants.X3.getY(), 0.0f);
		}
		if (waitForStop()) {
			return;
		}
		cd.setActive(false);
		if(executions==0)
		{
			db.enable();
		}
		executions++;
		if(executions==2)
		{
		executed = true;
		}
	}

}
