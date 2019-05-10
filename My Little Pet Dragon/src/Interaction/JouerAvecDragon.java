package Interaction;

import ObjetsInteractif.Dragon;
import item.Item;

public class JouerAvecDragon extends Interaction{

	Dragon dragon;
	
	public JouerAvecDragon(Dragon o)
	{
		dragon = o;
	}
	
	@Override
	public void run(Item i)
	{
		dragon.playWithDragon();
		
	}
	
	@Override
	public String getMessage()
	{
		return "Jouer avec le dragon.";
	}
}
