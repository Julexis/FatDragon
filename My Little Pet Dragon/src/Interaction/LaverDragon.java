package Interaction;

import item.*;
import ObjetsInteractif.*;

public class LaverDragon extends Interaction{

	
	public LaverDragon(ObjetInteractif o)
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
