package Interaction;

import ObjetsInteractif.ObjetInteractifDragon;
import item.Item;

public class InteractionJouerAvecDragon extends Interaction{

	ObjetInteractifDragon dragon;
	
	public InteractionJouerAvecDragon(ObjetInteractifDragon o)
	{
		dragon = o;
	}
	
	@Override
	public void run(Item i)
	{
		if (!dragon.isDeadDirty())
		{
			dragon.playWithDragon();
		}
		
	}
	
	@Override
	public String getMessage()
	{
		return "Jouer avec le dragon.";
	}
}
