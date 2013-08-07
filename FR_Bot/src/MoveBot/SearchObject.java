package MoveBot;

import lejos.nxt.LCD;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class SearchObject extends BehaviorParent{

	
	UltrasonicSensor us;
	
	
	public SearchObject(DifferentialPilot pilot) {
		super(pilot);
		us=new UltrasonicSensor(SensorPort.S4);
		us.continuous();
	}

	
	@Override
	public void action() {
		super.action();
		int range=0;
		int maxrange=45;
		boolean found=false;
		int angleperTurn=5;
		//int currentAngle=0;
		//int maxAngle=70;
		while(!found)
		{
			if(supressed)
			{
				return;
			}
			range=(int)us.getRange();
			found=range<maxrange;
			//if(!found)
			{
				rotate(angleperTurn,false);
				//currentAngle+=5;
				//if(currentAngle>maxAngle)
				{
					//angleperTurn*=-1;
					//currentAngle=-currentAngle;
				}
			}
		}
		range=adjust(range,1,false);
		if(range<0)
		{
			return;
		}
		travel(range,true);
		if(waitForStop())
		{
			return;
		}
		
		executed=true;
	}
	
	private int adjust(int range,int dir,boolean gotBEtter)
	{
		rotate(5*dir,true);
		Delay.msDelay(500);
		int tmprng=(int)us.getRange();
		if(tmprng>range)
		{
			dir*=-1;
			if(gotBEtter)
			{			
				rotate(13*dir,false);
				return (int)us.getRange();
			}
		}
		else{
			gotBEtter=true;
		}
		range=tmprng;		
		return adjust(range, dir,gotBEtter);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Searching object...";
	}
}
