package hsluchallange;

import fribot2013.BehaviorParent;

public abstract class DriveToParent extends BehaviorParent {
	protected DestroyBalloon db;
	protected CollisionDetect cd;
	
	public DriveToParent(DestroyBalloon db, CollisionDetect cd){
		this.db = db;
		this.cd = cd;
	}
	
	public void setExecuted(boolean executed){
		this.executed = executed;
	}

}
