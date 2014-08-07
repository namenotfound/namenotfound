import lejos.hardware.sensor.SensorMode;


public class _6_LineSearch extends BehaviorParent {

	@Override
	public void action() {
		executed = true;
		initBehavior();

		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		navi.goTo(230, 100, 0);
		if(waitFOrStop()){
			return;
		}	
		
		pilot.setTravelSpeed(Constants.SPEEDSLOW);
		pilot.travel(40);
		SensorMode lightMode=Constants.COLOR.getRedMode();
		int lightval;
		boolean found=false;
		while(!suppressed)
		{
			float[] values=new float[lightMode.sampleSize()];
			lightMode.fetchSample(values, 0);
			lightval =(int)(values[0]*100);
			if(lightval>30){
				found=true;
				break;
			}
		}
		if(found){
			pilot.rotate(90);
		}
		
	}

	
	@Override
	public String toString() {
		return "Line Search";
	}
}
