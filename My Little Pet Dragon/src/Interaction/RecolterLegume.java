package Interaction;
import ObjetsInteractif.Jardin;
import item.Item;
import item.Plante;

public class RecolterLegume extends Interaction{
	Jardin jardin;

	public RecolterLegume(Jardin jardin)
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
