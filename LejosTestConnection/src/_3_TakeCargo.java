import lejos.robotics.Color;
import lejos.robotics.SampleProvider;


public class _3_TakeCargo extends BehaviorParent {

	@Override
	public void action() {
		executed=true;
		initBehavior();
		
		Constants.MOTORMIDDLE.setAcceleration(160);
		Constants.MOTORMIDDLE.setSpeed(180);
		Constants.MOTORMIDDLE.rotate(70);
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		Constants.US.enable();
		SampleProvider distProvider=Constants.US.getDistanceMode();
		float[] samples=new float[distProvider.sampleSize()];
		distProvider.fetchSample(samples, 0);	
		float dist=samples[0]*100;
		
		Constants.MOTORMIDDLE.setAcceleration(160);
		Constants.MOTORMIDDLE.setSpeed(180);
		Constants.MOTORMIDDLE.rotate(-70);
		
		dist-=9;
		pilot.travel(dist,true);
		if(waitFOrStop()){
			return;
		}
		
		Constants.MOTORMIDDLE.setAcceleration(160);
		Constants.MOTORMIDDLE.setSpeed(180);
		Constants.MOTORMIDDLE.rotate(40);
		
		pilot.travel(-dist,true);
		if(waitFOrStop()){
			return;
		}
		


	}

	
	@Override
	public String toString() {
		return "Take Cargo";
	}
}
