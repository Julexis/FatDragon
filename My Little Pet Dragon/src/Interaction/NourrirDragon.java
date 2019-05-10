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
			Food f = (Food) i;
			dragon.feedDragon(f);
			
		} catch(Exception e)
		{
			
		}
		
		Food f = (Food) i;
		dragon.feedDragon(f);
		
	}
	
	@Override
	public String getMessage()
	{
		return "Nourrir le dragon.";
	}
}
