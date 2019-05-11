package Interaction;

import item.*;
import ObjetsInteractif.*;

public class InteractionPlanterGraine extends Interaction{
	
	ObjetInteractifJardin jardin;

	public InteractionPlanterGraine(ObjetInteractifJardin jardin)
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
