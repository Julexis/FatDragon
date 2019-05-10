package timer;

import ObjetsInteractif.Dragon;

//TimerEvent qui appel la méthode pour décrémenter les barres du dragon et incrémente sa taille.
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
