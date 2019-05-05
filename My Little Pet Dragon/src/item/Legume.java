package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Legume extends Food{
	private vegieType type;
	
	public Legume(grainType t)
	{
		
		try {
			vegieType v = vegieType.applePie;
			setImage(new Image ("./imagesItem/applePie.png"));
		switch(t)
		{
		case blue:
			v = vegieType.gingerale;
			setImage(new Image ("./imagesItem/gingerAle.png"));
			break;
		case red:
			v = vegieType.hotdog;
			setImage(new Image ("./imagesItem/hotdog.png"));
			break;
		case green:
			v = vegieType.orange;
			setImage(new Image ("./imagesItem/orange.png"));
		
			break;
		}
		type = v;
		}
		catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public vegieType getType() {
		return type;
	}
	
	public void setType(vegieType type) {
		this.type = type;
	}

}

