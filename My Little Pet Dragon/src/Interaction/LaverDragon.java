package Interaction;

import ObjetsInteractif.*;
import item.*;

public class LaverDragon extends Interaction{

	Dragon dragon;
	
	public LaverDragon(Dragon o)
	{
		dragon = o;
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			Sceau s = (Sceau)i;
			if (s.getIsFull())
			{
				s.empty();
				dragon.washDragon();
				
			}
			
		} catch(Exception e)
		{
			
		}
		
	}
	
	@Override
	public String getMessage()
	{
		return "Laver le dragon.";
	}
}
