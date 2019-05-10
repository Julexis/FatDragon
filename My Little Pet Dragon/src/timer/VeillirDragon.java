package timer;

import ObjetsInteractif.Dragon;

public class VeillirDragon extends TimerEvent{

	private Dragon dragon;
	
	public VeillirDragon(Dragon dragon)
	{
		super();
		this.dragon = dragon;
	}

	@Override
	public void trigger()
	{
		dragon.growDragon();
	}
}
