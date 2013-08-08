package shooter;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Touch extends BehaviorParent {

	
	TouchSensor ts1;
	TouchSensor ts2;
	int rotval;
	int ammo=0;
	
	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	public Touch(DifferentialPilot pilot) {
		super(pilot);
		ts1=new TouchSensor(SensorPort.S1);
		ts2=new TouchSensor(SensorPort.S2);
	}

	@Override
	public boolean takeControl() {
		// TODO Auto-generated method stub
		rotval=ts2.isPressed()?Constants.cRand.nextInt(70)+90:-(Constants.cRand.nextInt(70)+90);
		return ts1.isPressed()||ts2.isPressed();
	}

	@Override
	public void action() {
		super.action();
		
		pilot.setAcceleration(50);
		pilot.setTravelSpeed(Constants.speedSlow);
		travel(-20,true);
		if(waitForStop())
		{
			pilot.stop();
			return;
		}
		rotate(rotval,true);
		if(waitForStop())
		{
			pilot.stop();
			return;
		}
		
		Constants.motorCentral.setAcceleration(2000);
		Constants.motorCentral.setSpeed(600);
		Constants.motorCentral.rotate(360);
		ammo--;
		if(waitForMotorStop(Constants.motorCentral))
		{
			Constants.motorCentral.stop();
			return;
		}
	}

	
	
	
}
