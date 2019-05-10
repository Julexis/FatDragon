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
				setImage(new Image("./imagesItem/GraineJaune"));
				break;
			case blue:
				niveauDeCompletion = 60;
				setImage(new Image("./imagesItem/GraineBleue"));
				break;
			case red:
				niveauDeCompletion = 75;
				setImage(new Image("./imagesItem/GraineRouge"));
				break;
			case green:
				niveauDeCompletion = 20;
				setImage(new Image("./imagesItem/GraineVerte"));
				break;
			} 
		}catch (SlickException e) {
		e.printStackTrace();
		}
	}
	
	//getter setter
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
