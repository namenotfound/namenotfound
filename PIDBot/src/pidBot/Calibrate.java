package pidBot;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Waypoint;
import lejos.util.Delay;

public class Calibrate extends BehaviorParent {

	@Override
	public void action() {
		// TODO Auto-generated method stub
		super.action();
		
		//calOdometry();
		//calLight();
		calTurn();
		executed=true;
		
	}
	
	
	private void calLight()
	{
		
		while(!supressed)
		{
			
			int i=light.getRawLightValue();
			LCD.clear(2);
			LCD.drawInt(i, 3, 0, 2);
			Delay.msDelay(500);
			
			
		}
		
	}
	
	
	private void calOdometry()
	{
		LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
		pilot.travel(30);
		waitForStop();
		LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
		pilot.rotate(90);
		waitForStop();
		LCD.drawString(navi.getPoseProvider().getPose().toString()+"", 0, 2);
		
		navi.goTo(0, 0, 0);
		LCD.drawString(navi.getPoseProvider().getPose().toString()+"", 0, 2);
	}
	
	private void calTurn()
	{
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		//pilot.forward();
		
		//Delay.msDelay(1000);
		
		pilot.steer(60);
		
		
		
		
		for(int i=0;i<10;i++)
		{
			Delay.msDelay(500);
		LCD.drawString(navi.getPoseProvider().getPose().toString(), 0, 2);
		LCD.drawString(navi.getPoseProvider().getPose().getHeading()+"", 0,3 );
		}
		pilot.stop();
	//	pilot.steer(-60);
		
		Delay.msDelay(2000);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Calibrate";
	}
	
}
