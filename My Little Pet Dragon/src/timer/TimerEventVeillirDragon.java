package timer;

import ObjetsInteractif.ObjetInteractifDragon;

//TimerEvent qui appel la méthode pour décrémenter les barres du dragon et incrémente sa taille.
public class TimerEventVeillirDragon extends TimerEvent{

	private ObjetInteractifDragon dragon;
	
	public TimerEventVeillirDragon(ObjetInteractifDragon dragon)
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
