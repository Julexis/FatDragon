package Interaction;

import item.*;
import objetsInteractif.*;

public class PlanterGraine extends Interaction{
	
	public PlanterGraine(ObjetInteractif o)
	{
		super(o);
	}

	
	
	@Override
	public void run(Item i)
	{
		try
		{
			Jardin g = (Jardin)structure;
			Graine s = (Graine)i;
			
			g.putGraine(s);
		}
		catch(Exception e)
		{
			//here
		}
		
	}
	
	@Override
	public String getMessage()
	{
		return "Planter une graine.";
	}
}
