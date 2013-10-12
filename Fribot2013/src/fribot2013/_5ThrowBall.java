package fribot2013;

import lejos.util.Delay;

public class _5ThrowBall extends BehaviorParent {

	
	@Override
	public void action() {
		super.action();
		
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.goTo(180, 100, 180);
		if (waitForStop()) {
			return;
		}
		pilot.setAcceleration(390);
		pilot.setTravelSpeed(Constants.SPEEDINSANE);
		pilot.forward();
		while(true&&!supressed)
		{
			int lightVal=light.getNormalizedLightValue();
			if(lightVal<185)
			{
				break;
			}
			Delay.msDelay(10);
		}
		if(supressed)
		{
			return;			
		}
		
		Constants.MOTORMIDDLE.setAcceleration(400);
		Constants.MOTORMIDDLE.setSpeed(100);
		Constants.MOTORMIDDLE.rotate(90,true);
		
		Delay.msDelay(100);
		
		pilot.stop();
		
		
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Throw Ball";
	}
}
