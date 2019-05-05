package Interaction;

import item.Item;
import ObjetsInteractif.*;

public class JouerAvecDragon extends Interaction{

	
	public JouerAvecDragon(ObjetInteractif o)
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
		catch(Exception e)
		{
			//here
		}
	}
	
	@Override
	public String getMessage()
	{
		return "Jouer avec le dragon.";
	}
}
