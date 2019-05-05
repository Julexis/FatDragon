package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sceau extends Item{
	private Boolean isFull;
	private Image imagePlein;
	private Image imageVide;
	public Sceau()
	{
		setDestructable(true);
		try {
			imagePlein=(new Image("./imagesItem/SceauPlein"));
			imageVide=(new Image("./imagesItem/SceauVide"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setImage(imageVide);
	}
	
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
