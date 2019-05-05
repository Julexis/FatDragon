package animal;

import java.util.ArrayList;

import org.newdawn.slick.*;
import java.awt.Font;
import org.newdawn.slick.tiled.TiledMap;

import Interaction.Interaction;
import ObjetsInteractif.ObjetInteractif;
import item.Inventaire;
public class Joueur extends Animal{
	
	
	
	private int calqueInteragir;
	private Input inputJoueur;
	private Inventaire invent;
	private int size;
	private ObjetInteractif objetEnCours;
	private ArrayList<Interaction> listeInteractionEnCours;
	private boolean interactionAffiche;
	TrueTypeFont fonty;
	//private textField
	public ObjetInteractif getObjetEnCours() {
		return objetEnCours;
	}

	public void setObjetEnCours(ObjetInteractif objetEnCours) {
		this.objetEnCours = objetEnCours;
	}

	public Joueur(float emplacementX, float emplacementY, float deplacement, int size) throws SlickException {
		
		super(emplacementX,emplacementY,deplacement,size,new Image("./images/monSprite.png"));
		
		
		this.setCalqueInteragir(calqueInteragir);
		invent=new Inventaire(new Image("./ressourceJeu/fondInventaire.png"),new Image("./ressourceJeu/case.png"),new Image("./ressourceJeu/caseContour.png"),3,3,110,100);
		invent.setSelectionX(0);
		invent.setSelectionY(0);
		Font awtFont = new Font("Times New Roman", Font.BOLD, 10);
		fonty = new TrueTypeFont( awtFont, false);
	}

	public void deplacement(Input inputJoueur) {
		
		
		
		this.inputJoueur=inputJoueur;
		
		moving=true;
		if(this.inputJoueur.isKeyDown(Input.KEY_RIGHT))
		{
			if(getMap().getTileId((int)getEmplacementX()+1, (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementX(getEmplacementX() +getDeplacement()); 
				setDirection(Direction.RIGHT);
			}
		}
	
		else if(this.inputJoueur.isKeyDown(Input.KEY_LEFT))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementX(getEmplacementX() - getDeplacement());
				setDirection(Direction.LEFT);
			}
			
		}
		else if(this.inputJoueur.isKeyDown (Input.KEY_UP))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementY(getEmplacementY() - getDeplacement());
				setDirection(Direction.UP);
			}
			
		}
		else if(this.inputJoueur.isKeyDown(Input.KEY_DOWN))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY()+1, getCalqueBloquer())==0)
			{
				setEmplacementY(getEmplacementY() + getDeplacement());
				setDirection(Direction.DOWN);
			}
			
		}
		else
		{
			moving=false;
		}
		
	}
	
	public void InputJoueur(Input inputJoueur)
	{
		if(inputJoueur.isKeyPressed(Input.KEY_E))
		{
			invent.setAffiche(!invent.isAffiche());
			updateOptionListe();
	
		}
		 if(!invent.isAffiche())
		{
			deplacement(inputJoueur);
		}
		 else
		 {
			 
			 choixIndex(inputJoueur);
		 }
	}
	public void drawInvent()
	{
		if(invent.isAffiche())
		{
			invent.Affiche();
		}
		
	}
	
	public ArrayList<Interaction> getListeInteractionEnCours() {
		
		return listeInteractionEnCours;
	}

	public void setListeInteractionEnCours(ArrayList<Interaction> listeInteractionEnCours) {
		this.listeInteractionEnCours = listeInteractionEnCours;
	}

	public void choixIndex(Input inputJoueur)
	{
		this.inputJoueur=inputJoueur;
		if(this.inputJoueur.isKeyPressed(Input.KEY_RIGHT))
		{
			invent.setSelectionX(invent.getSelectionX()+1);
		}
		else if(this.inputJoueur.isKeyPressed(Input.KEY_LEFT))
		{
			
			invent.setSelectionX(invent.getSelectionX()-1);

		}
		else if(this.inputJoueur.isKeyPressed(Input.KEY_UP))
		{
			invent.setSelectionY(invent.getSelectionY()-1);

		}
		else if(this.inputJoueur.isKeyPressed(Input.KEY_DOWN))
		{
			invent.setSelectionY(invent.getSelectionY()+1);

		}
		if(invent.getSelectionX()>invent.getLine()-1)
		{
			invent.setSelectionX(invent.getLine()-1);
		}
		if(invent.getSelectionY()>invent.getRow()-1)
		{
			invent.setSelectionY(invent.getRow()-1);
		}
		if(invent.getSelectionX()<0)
		{
			invent.setSelectionX(0);
		}
		if(invent.getSelectionY()<0)
		{
			invent.setSelectionY(0);
		}
	}
	public Inventaire getInvent() {
		return invent;
	}
	public void updateOptionListe()
	{
		if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY()+1,calqueInteragir)==1)
		{
			interactionAffiche=true;
		}
		else
		{
			interactionAffiche=false;
		}
	}
	public void drawOptions()
	{
		if(invent.isAffiche()&&interactionAffiche)
		{
			invent.getImageFond().draw(10,invent.getEmplacementYimageFond(),90,100);
			int y=20;
			
			for(Interaction i:listeInteractionEnCours)
			{
				fonty.drawString(10, invent.getEmplacementYimageFond()+y, i.getMessage());
				y+=20;
			}
		}
	}
	public void setInvent(Inventaire invent) {
		this.invent = invent;
	}

	public int getCalqueInteragir() {
		return calqueInteragir;
	}

	public void setCalqueInteragir(int calqueInteragir) {
		this.calqueInteragir = calqueInteragir;
	}

}
