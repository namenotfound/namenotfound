package hsluchallange;

import fribot2013.BehaviorParent;

public class CollisionDetect extends BehaviorParent{

	private boolean active=false;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		
		//this.active = active;
	}

	@Override
	public boolean takeControl() {
		if(!active)
		{
			return false;
		}
		us.continuous();
		return us.getRange()<10;
	}
	
	@Override
	public void action() {
		super.action();
		pilot.travel(-10);
		if(waitForStop())
		{
			return;
		}
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Collision Detect";
	}
}
