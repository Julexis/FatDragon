package Interaction;

import item.*;
import ObjetsInteractif.*;

public class InteractionNourrirDragon extends Interaction{
	
	
	public InteractionNourrirDragon(ObjetInteractif o)
	{
		super(o);
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			Dragon drag = (Dragon)structure;
			
			Food f = (Food) i;
			drag.feedDragon(f);
		}
		catch (Exception e)
		{
			//todo code pour les item i non-food
		}
	}
	
	@Override
	public String getMessage()
	{
		return "Nourrir le dragon.";
	}
}
