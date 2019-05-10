package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Plante extends Item{
	private grainType type;
	private int niveauDeCompletion;
	
	
	public Plante(grainType type)
	{
		this.type = type;
		try {
			switch(type)
			{
			case yellow:
				niveauDeCompletion = 100;
				setImage(new Image("./imagesItem/GraineJaune.png"));
				break;
			case blue:
				niveauDeCompletion = 60;
				setImage(new Image("./imagesItem/GraineBleue.png"));
				break;
			case red:
				niveauDeCompletion = 75;
				setImage(new Image("./imagesItem/GraineRouge.png"));
				break;
			case green:
				niveauDeCompletion = 20;
				setImage(new Image("./imagesItem/GraineVerte.png"));
				break;
			} 
		}catch (SlickException e) {
		e.printStackTrace();
		}
	}
	public grainType getType() {
		return type;
	}
	public void setType(grainType type) {
		this.type = type;
	}
	public int getNiveauDeCompletion() {
		return niveauDeCompletion;
	}
	public void setNiveauDeCompletion(int niveauDeCompletion) {
		this.niveauDeCompletion = niveauDeCompletion;
	}
}
