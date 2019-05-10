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
		Graine s = (Graine)i;
			
		jardin.putGraine(s);
	}
	
	@Override
	public String getMessage()
	{
		return "Planter une graine.";
	}
}
