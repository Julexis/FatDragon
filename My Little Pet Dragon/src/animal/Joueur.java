package animal;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import item.Inventaire;
import ObjetsInteractif.Direction;
public class Joueur extends Animal{
	
	
	
	private int calqueInteragir;
	private Input inputJoueur;
	private Inventaire invent;
	private int size;
	
	public Joueur(float emplacementX, float emplacementY, float deplacement, int size) throws SlickException {
		
		super(emplacementX,emplacementY,deplacement,size,new Image("./images/monSprite.png"));
		
		
		this.setCalqueInteragir(calqueInteragir);
		invent=new Inventaire(new Image("./ressourceJeu/fondInventaire.png"),new Image("./ressourceJeu/case.png"),new Image("./ressourceJeu/caseContour.png"));
		invent.setSelectionX(0);
		invent.setSelectionY(0);
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
		if(invent.getSelectionX()>2)
		{
			invent.setSelectionX(2);
		}
		if(invent.getSelectionY()>2)
		{
			invent.setSelectionY(2);
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
