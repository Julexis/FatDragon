package Interaction;

import item.*;

public class InteractionRemplirSceau extends Interaction{
	
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
		return "Remplir un seau d'eau.";
	}
}
