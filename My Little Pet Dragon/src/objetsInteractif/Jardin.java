package ObjetsInteractif;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import item.Inventaire;
import timer.TimerEvent;
import timer.VieillirJardin;
import Interaction.*;

import item.*;

public class Jardin extends ObjetInteractif{
	
	TimerEvent timerEvent = new VieillirJardin(this);
	private Inventaire inventaireJardin;
	Inventaire inventaireJoueur;
	private ArrayList<Plante> listePlante = new ArrayList<Plante>();

	public Jardin(Inventaire i) throws SlickException
	{
		setInventaireJardin(new Inventaire(new Image("./ressourceJeu/fondInventaire.png"),new Image("./ressourceJeu/case.png"),new Image("./ressourceJeu/caseContour.png"),3,2,250,100));

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
	public void showInventaire()
	{
		getInventaireJardin().Affiche();
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

	public Inventaire getInventaireJardin() {
		return inventaireJardin;
	}

	public void setInventaireJardin(Inventaire inventaireJardin) {
		this.inventaireJardin = inventaireJardin;
	}
}
