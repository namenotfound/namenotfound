package shooter;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class GoHome extends BehaviorParent {

	private Touch touch;
	private boolean first=true;
	public GoHome(DifferentialPilot pilot,Touch touch) {
		super(pilot);
		// TODO Auto-generated constructor stub
		this.touch=touch;
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		return touch.getAmmo()<=0;
	}

	@Override
	public void action() {
		super.action();
		if(!first)
		{
		navi.goTo(22, -7, 0);
		waitForStop();
		}
		else{
			first=false;
		}
		while(!Button.ENTER.isDown()&&!supressed)
		{
			LCD.clear(3);
			LCD.drawString("Ammo: "+touch.getAmmo(), 0, 3);
			if(Button.LEFT.isDown())
			{
				while(Button.LEFT.isDown()&&!supressed)
				{
					Delay.msDelay(10);
				}
				if(touch.getAmmo()>0)
				{
				touch.setAmmo(touch.getAmmo()-1);
				}
			}
			if(Button.RIGHT.isDown())
			{
				while(Button.RIGHT.isDown()&&!supressed)
				{
					Delay.msDelay(10);
				}
				if(touch.getAmmo()<6)
				{
				touch.setAmmo(touch.getAmmo()+1);
				}
			}
			Delay.msDelay(10);
		}
	}

	
	
	
	
}
