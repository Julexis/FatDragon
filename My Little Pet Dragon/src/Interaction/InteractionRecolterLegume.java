package Interaction;
import ObjetsInteractif.ObjetInteractifJardin;
import item.Item;
import item.Plante;

public class InteractionRecolterLegume extends Interaction{
	ObjetInteractifJardin jardin;

	public InteractionRecolterLegume(ObjetInteractifJardin jardin)
	{
		this.jardin = jardin;
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			Plante p = (Plante)i;
			if (p.getNiveauDeCompletion() == 0)
			{
				jardin.harvest(p);
				jardin.getInventaireJardin().suppress();
			}
			
		}catch(Exception e)
		{
			
		}
	}
	
	@Override
	public String getMessage()
	{
		return "Recolter un legume.";
	}
}
