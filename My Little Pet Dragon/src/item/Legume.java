package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//Récolter dans le jardin. Peut être donner au dragon.
public class Legume extends Food{
	private vegieType type;
	
	public Legume(grainType t)
	{
		
		try {
			switch(t)//Initialise le legume en fonction de la sorte de grain
			{
			case blue:
				type = vegieType.gingerale;
				setImage(new Image ("./imagesItem/gingerAle.png"));
				this.setFoodValue(50);
				break;
			case red:
				type = vegieType.hotdog;
				setImage(new Image ("./imagesItem/hotdog.png"));
				this.setFoodValue(45);
				break;
			case green:
				type = vegieType.orange;
				setImage(new Image ("./imagesItem/orange.png"));
				this.setFoodValue(35);
				break;
			default:
				type = vegieType.applePie;
				setImage(new Image ("./imagesItem/applePie.png"));
				this.setFoodValue(85);
			}
		}
		catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//getter setter
	public vegieType getType() {
		return type;
	}
	
	public void setType(vegieType type) {
		this.type = type;
	}

}

