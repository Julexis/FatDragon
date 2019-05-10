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
	

	public Jardin(Inventaire i) throws SlickException
	{
		inventaireJardin=new Inventaire(new Image("./ressourceJeu/fondInventaire.png"),new Image("./ressourceJeu/case.png"),new Image("./ressourceJeu/caseContour.png"),3,2,250,100);

		inventaireJoueur = i;
		listeInteraction.add(new PlanterGraine(this));
		listeInteraction.add(new RecolterLegume(this));
	}
	
	public void putGraine(Graine g)
	{
		Plante p = new Plante(g.getType());
		inventaireJardin.addObjet(p);
		
	}
	
	public void harvest(Plante p)
	{
		
		Legume l = new Legume(p.getType());
		inventaireJoueur.addObjet(l);
	}
	
	

	
	public void showInventaire()
	{
		getInventaireJardin().Affiche();
	}
	public void growPlants()
	{
		for(Item i: inventaireJardin.getItems())
		{
			try {
				Plante p=(Plante)i;
				int comp = p.getNiveauDeCompletion()-1;
				
				if (comp < 0)
				{
					p.setNiveauDeCompletion(0);
				}
				else
				{
					p.setNiveauDeCompletion(comp);
				}
			}catch(Exception e)
			{
				
			}
		}
	}

	public Inventaire getInventaireJoueur() {
		return inventaireJoueur;
	}

	public void setInventaireJoueur(Inventaire inventaireJoueur) {
		this.inventaireJoueur = inventaireJoueur;
	}

	public Inventaire getInventaireJardin() {
		return inventaireJardin;
	}

	public void setInventaireJardin(Inventaire inventaireJardin) {
		this.inventaireJardin = inventaireJardin;
	}
}
