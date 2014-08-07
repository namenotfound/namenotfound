import lejos.robotics.Color;

public class _2_GoToCorrectCargo extends BehaviorParent {

	@Override
	public void action() {
		executed=true;
		initBehavior();
		pilot.setTravelSpeed(Constants.SPEEDMEDIUM);
		Constants.COLOR.setFloodlight(true);
		int xDest=210;
		int yDest=0;
		int heading=0;
	//	if (Constants.COLOR.getColorID() == Color.BROWN) {
			yDest=60;
			heading=-90;
		/*} else {
			yDest=90;
			heading=90;
		}*/
		navi.goTo(xDest, yDest, heading);
		if (waitFOrStop()) {
			return;
		}

	}

	@Override
	public String toString() {
		return "Goto Correct Cargo";
	}
}
