package animal;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public class Joueur extends Animal{
	
	
	
	private int calqueInteragir;
	private Input inputJoueur;
	
	private int size;
	
	public Joueur(float emplacementX, float emplacementY, float deplacement, int size) throws SlickException {
		
		super(emplacementX,emplacementY,deplacement,size,new Image("./images/smiley.png"));
		
		
		this.setCalqueInteragir(calqueInteragir);
		
	}

	public void deplacement(Input inputJoueur) {
		
		
		this.inputJoueur=inputJoueur;
		
		
		if(this.inputJoueur.isKeyDown(Input.KEY_RIGHT))
		{
			if(getMap().getTileId((int)getEmplacementX()+1, (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementX(getEmplacementX() +getDeplacement());
			}
		}
	
		else if(this.inputJoueur.isKeyDown(Input.KEY_LEFT))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementX(getEmplacementX() - getDeplacement());
			}
			
		}
		else if(this.inputJoueur.isKeyDown (Input.KEY_UP))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementY(getEmplacementY() - getDeplacement());
			}
			
		}
		else if(this.inputJoueur.isKeyDown(Input.KEY_DOWN))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY()+1, getCalqueBloquer())==0)
			{
				setEmplacementY(getEmplacementY() + getDeplacement());
			}
			
		}
		
		
	}

	public int getCalqueInteragir() {
		return calqueInteragir;
	}

	public void setCalqueInteragir(int calqueInteragir) {
		this.calqueInteragir = calqueInteragir;
	}

}
