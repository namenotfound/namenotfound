import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.Pose;
import lejos.utility.Delay;

public class _5_FindObject extends BehaviorParent {

	@Override
	public void action() {
		executed = true;
		initBehavior();
		
		navi.getPoseProvider().setPose(new Pose(24.5f, 32f, 0));
		
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo(50, 60, 0);
		if(waitFOrStop()){
			return;
		}		
		
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		pilot.travel(80,true);
		Constants.US.enable();
		SampleProvider distProvider = Constants.US.getDistanceMode();
		float[] samples = new float[distProvider.sampleSize()];
		boolean found = false;
		float dist=0;
		while (pilot.isMoving()) {
			distProvider.fetchSample(samples, 0);
			dist = samples[0] * 100;
			if (suppressed) {
				pilot.stop();
				return;
			}
			if (dist < 50) {
				found = true;
				break;
			}
			Delay.msDelay(100);
		}
		if (found) {
			pilot.rotate(90);
			pilot.travel(dist);
			
			Constants.MOTORMIDDLE.setAcceleration(720);
			Constants.MOTORMIDDLE.setSpeed(720);
			Constants.MOTORMIDDLE.rotate(80);
			
			pilot.travel(-dist);
			pilot.rotate(-90);
			navi.goTo(130, 60, 0);
			if(waitFOrStop()){
				return;
			}
		}

	}
	
	
	@Override
	public String toString() {
		return "Find Object";
	}
}
