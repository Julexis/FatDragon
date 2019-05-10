package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//nourriture "dropped" par les phacocheres
public class Viande extends Food{
	
	public Viande ()
	{
		try {
			setImage(new Image("./imagesItem/viande.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
