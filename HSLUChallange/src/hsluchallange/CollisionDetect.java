package hsluchallange;

public class CollisionDetect extends BehaviorParent{

	private boolean active=true;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	
}
