package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//Peut être remplit par le lac. Peut être utilisé pour laver le dragon.
public class Sceau extends Item{
	private Boolean isFull;
	private Image imagePlein;
	private Image imageVide;
	public Sceau()
	{
		setDestructable(true);
		try {
			imagePlein=(new Image("./imagesItem/SceauPlein.png"));
			imageVide=(new Image("./imagesItem/SceauVide.png"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setImage(imageVide);
	}
	
	
	//getter setter
	public Boolean getIsFull() {
		return isFull;
	}
	
	public void fill() {
		this.isFull = true;
		setImage(imagePlein);
	}
	
	public void empty() {
		this.isFull = false;
		setImage(imageVide);
	}
	
}
