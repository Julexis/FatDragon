package Interaction;

import ObjetsInteractif.*;
import item.*;

public class InteractionLaverDragon extends Interaction{

	
	public InteractionLaverDragon(ObjetInteractif o)
	{
		super(o);
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			Dragon drag = (Dragon)structure;
			
			drag.playWithDragon();
		}
		catch (Exception e)
		{
			//here
		}
	}
	
	@Override
	public String getMessage()
	{
		return "Laver le dragon.";
	}
}
