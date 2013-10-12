package fribot2013;

import lejos.nxt.LCD;
import lejos.robotics.navigation.Pose;

public class _1FinalT1 extends BehaviorParent {

	@Override
	public void action() {
		super.action();
		int progress = 0;
		int track = 1;
		int dist1=0;
		int dist2=0;
		int dist3=0;
		float y1=120-12.5f;
		float y2=120-40f;
		float y3=120-68f;
		pilot.setAcceleration(Constants.ACCELERATION);
		navi.getPoseProvider().setPose(new Pose(25, 12.5f, 0));
		pilot.travel(-2);
		// Scann,rechts fahren...
		us.continuous();

		int dist = us.getDistance();
		
		
		
		LCD.clear(3);
		LCD.drawInt(dist, 0, 3);
		dist1=parseDist(dist);
		if(dist1==4)
		{
			//pilot.travel(150);
			//return;
		}
		//drive to track 2
			pilot.rotate(90);
			pilot.travel(-(y1-y2));
			pilot.rotate(-90);
			dist = us.getDistance();
			
			
			LCD.clear(3);
			LCD.drawInt(dist, 0, 3);
			
			
			
			
			dist2 = parseDist(dist);
			if(dist2==4)
			{
				//pilot.travel(150);
			//	return;
			}
			//drive to track 3
			pilot.rotate(-90);
			pilot.travel(y2-y3);
			pilot.rotate(90);
			dist = us.getDistance();
			
			
			LCD.clear(3);
			LCD.drawInt(dist, 0, 3);
			
			
			
			dist3 = parseDist(dist);
			if(dist3==4)
			{
			//	pilot.travel(150);
			//	return;
			}
			LCD.clear(3);
			LCD.clear(4);
			LCD.clear(5);
			LCD.drawInt(dist1, 0, 3);
			LCD.drawInt(dist2, 0, 4);
			LCD.drawInt(dist3, 0, 5);
			
		//3 grösster
			if(dist3>dist2&&dist3>dist1)
			{
				track=3;
				pilot.travel(30*(2));
				
				int d=parseDist(us.getDistance());
				if(d>1)
				{
					pilot.travel(30);
			
				}
				pilot.rotate(-90);
				pilot.travel(-(y2-y3));
				pilot.rotate(90);
				
				//vorne schauen
				d=parseDist(us.getDistance());
				if(d==1)
				{
					pilot.rotate(90);
					pilot.travel((y1-y2));
					pilot.rotate(-90);
					//wenn stufe 3 dann fiel fahren sonst weniger
					pilot.travel(95);
				}
				else if(d==2)
				{
					pilot.travel(30);
					pilot.rotate(90);
					pilot.travel((y1-y2));
					pilot.rotate(-90);
					pilot.travel(45);
				}
				else{
					
					pilot.travel(95);
				}
				return;
				
				
			}
			if(dist2>dist3&&dist2>dist1)
			{
				track=2;
				pilot.rotate(-90);
				pilot.travel(-(y2-y3));
				pilot.rotate(90);
				pilot.travel(30*2);
				
				int d=parseDist(us.getDistance());
				if(d>1)
				{
					pilot.travel(30);
				}
				
				//links messen
				pilot.rotate(90);
				d=us.getDistance();
				if(d>30)
				{
					//links frei
					pilot.travel(y1-y2);
					pilot.rotate(-90);
					//wenn stufe 3 dann fiel fahren sonst weniger
					pilot.travel(95);
				}
				else{
					pilot.rotate(180);
					pilot.travel(y2-y3);
					pilot.rotate(90);
					//wenn stufe 3 dann fiel fahren sonst weniger
					pilot.travel(95);
				}
				
				return;
			}
			if(dist1>dist2&&dist1>dist3)
			{
				track=1;
				pilot.rotate(-90);
				pilot.travel(-(y2-y3));
				pilot.rotate(180);
				pilot.travel(y1-y2);
				pilot.rotate(-90);
				pilot.travel(30*2);
				
				int d=parseDist(us.getDistance());
				if(d>1)
				{
				pilot.travel(30);
				}
				
				pilot.rotate(90);
				pilot.travel(-(y1-y2));
				pilot.rotate(-90);
				//vorne schauen
				d=parseDist(us.getDistance());
				if(d==1)
				{
					pilot.rotate(-90);
					pilot.travel((y2-y3));
					pilot.rotate(100);
					//wenn stufe 3 dann fiel fahren sonst weniger
					pilot.travel(95);
				}
				else if(d==2)
				{
					pilot.travel(30);
					pilot.rotate(-90);
					pilot.travel((y2-y3));
					pilot.rotate(100);
					pilot.travel(45);
				}
				else{
					
					pilot.travel(95);
				}
				pilot.rotate(40);
				pilot.travel(40);
				return;
			}
			

	}
	

	private int parseDist(int dist) {
		if (dist < 26) {
			return 1;
		}
		else if (dist < 56) {
			return 2;
		}
		else if (dist < 86) {
			return 3;
		}
		else  {
			return 4;
		}
	}

	private boolean checkForObstacle() {
		us.continuous();
		int range = (int) us.getRange();
		return range < 35;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Final T1";
	}

}
