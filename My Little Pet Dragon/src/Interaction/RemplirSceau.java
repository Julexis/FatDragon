package Interaction;

import item.*;
import objetsInteractif.*;

public class RemplirSceau extends Interaction{
	
	
	public RemplirSceau(ObjetInteractif o)
	{
		super(o);
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			Sceau s = (Sceau) i;
			s.fill();
		}
		catch (Exception e)
		{
			//todo: code pour un objet non-sceau
		}
	}
	
	@Override
	public String getMessage()
	{
		return "Remplir un sceau.";
	}
}
