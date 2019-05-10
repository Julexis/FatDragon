package Interaction;

import item.*;
import ObjetsInteractif.*;

public class NourrirDragon extends Interaction{
	
	Dragon dragon;
	
	public NourrirDragon(Dragon dragon)
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
