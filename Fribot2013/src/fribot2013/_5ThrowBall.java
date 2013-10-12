package fribot2013;

import lejos.util.Delay;

public class _5ThrowBall extends BehaviorParent {

	
	@Override
	public void action() {
		super.action();
		if(executed)
		{
			return;
		}
		
		pilot.setAcceleration(Constants.ACCELERATION);
		pilot.rotate(45);
		pilot.travel(-10);
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		pilot.rotate(-118);
		
		pilot.setAcceleration(400);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		pilot.travel(32);
		
		Constants.MOTORMIDDLE.setAcceleration(3000);
		Constants.MOTORMIDDLE.setSpeed(1000);
		Constants.MOTORMIDDLE.rotate(-120);
		

		
		pilot.stop();
		
		executed=true;
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Throw Ball";
	}
}
