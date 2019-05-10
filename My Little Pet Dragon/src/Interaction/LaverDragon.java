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
		dragon.playWithDragon();
	}
	
	@Override
	public String getMessage()
	{
		return "Laver le dragon.";
	}
}
