package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import timer.TimerEvent;

//Trouver dans la forêt. Peut être planter dans le jardin.
public class Graine extends Item{
	
	private grainType type;
	
	
	public Graine(grainType type)
	{
		
		this.type = type;
		try {
				switch(type)//Initialise le legume en fonction de la sorte de grain
				{
				case blue:
					setImage(new Image ("./imagesItem/GraineBleue.png"));
					break;
				case red:
					setImage(new Image ("./imagesItem/GraineRouge.png"));
					break;
				case green:
					setImage(new Image ("./imagesItem/GrainVerte.png"));
					break;
				default:
					setImage(new Image ("./imagesItem/GraineJaune.png"));
				}
			}
			catch (SlickException e) {
				// TODO Auto-generated catch block
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
}
