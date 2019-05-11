package ObjetsInteractif;

import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

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
				float comp = p.getNiveauDeCompletion()-1;
				
				if (comp < 0)
				{
					p.setNiveauDeCompletion(0);
					p.setImage(p.getImagePousser());
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
	public void afficherPlants()
	{
		 ArrayList <Item> plants=inventaireJardin.getItems();
		 int x,y,emplacement;
		float hauteurLargeur;
		 x=160;
		 y=140;
		 emplacement=0;
		 for(Item i :plants)
		 {
			 Plante p = (Plante)i;
			 hauteurLargeur= (p.getCompletionMax()-p.getNiveauDeCompletion())/p.getCompletionMax();
			 hauteurLargeur*=40;
			p.getImage().draw(x-(hauteurLargeur/2)/2,y-hauteurLargeur/2,hauteurLargeur/2,hauteurLargeur);
			emplacement++;
			if(emplacement%2==1)
			{
				x+=80;
			}
			else
			{
				x-=80;
				y+=60;
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
