package ObjetsInteractif;

import java.util.ArrayList;
import item.Inventaire;
import timer.TimerEvent;
import timer.VieillirJardin;
import Interaction.*;

import item.*;

public class Jardin extends ObjetInteractif{
	
	TimerEvent timerEvent = new VieillirJardin(this);
	
	Inventaire inventaireJoueur;
	private ArrayList<Plante> listePlante = new ArrayList<Plante>();

	public Jardin(Inventaire i)
	{
		inventaireJoueur = i;
		listeInteraction.add(new PlanterGraine(this));
		listeInteraction.add(new RecolterLegume(this));
	}
	
	public void putGraine(Graine g)
	{
		Plante p = new Plante(g.getType());
		listePlante.add(p);
	}
	
	public void harvest(Plante p)
	{
		listePlante.remove(p);
		Legume l = new Legume(p.getType());
		//inventaireJoueur.addStuff();
	}
	
	public ArrayList<Plante> getListePlante() {
		return listePlante;
	}

	public void setListePlante(ArrayList<Plante> listePlante) {
		this.listePlante = listePlante;
	}
	
	public void growPlants()
	{
		for(Plante p: listePlante)
		{
			int comp = p.getNiveauDeCompletion()-1;
			
			if (comp < 0)
			{
				p.setNiveauDeCompletion(0);
			}
			else
			{
				p.setNiveauDeCompletion(comp);
			}
		}
	}
}
