package Interaction;

import item.*;
import ObjetsInteractif.*;

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
