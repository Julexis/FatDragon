package Interaction;

import item.*;
import ObjetsInteractif.*;

public class PlanterGraine extends Interaction{
	
	Jardin jardin;

	public PlanterGraine(Jardin jardin)
	{
		this.jardin = jardin;
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			Graine g = (Graine)i;
				
			jardin.putGraine(g);
			jardin.getInventaireJoueur().suppress();
		} catch(Exception e)
		{
			
		}
	}
	
	@Override
	public String getMessage()
	{
		return "Planter une graine.";
	}
}
