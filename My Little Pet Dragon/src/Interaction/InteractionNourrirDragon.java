package Interaction;

import item.*;
import ObjetsInteractif.*;

public class InteractionNourrirDragon extends Interaction{
	
	ObjetInteractifDragon dragon;
	
	public InteractionNourrirDragon(ObjetInteractifDragon dragon)
	{
		this.dragon = dragon;
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			//Le dragon ne mange que s'il n'est pas tout triste :( 
			Food f = (Food) i;
			if (!dragon.isDeadSad())
			{
				
				dragon.feedDragon(f);
				dragon.getInventJoueur().suppress();
			}
			
		} catch(Exception e)
		{
			
		}
		
	}
	
	@Override
	public String getMessage()
	{
		return "Nourrir le dragon.";
	}
}
