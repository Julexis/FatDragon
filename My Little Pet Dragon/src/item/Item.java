package item;

import org.newdawn.slick.Image;

//class abstraite d'item
public class Item {
	private boolean isDestructable = true;//Determine si l'objet peut être défausser par le joueur
	//(en résumé, tout sauf le sceau!)
	
	private  Image image;//image de l'objet
	
	//getter setter
	public  Image getImage() {
		return image;
	}
	public  void setImage(Image image) {
		this.image = image;
	}
	
	//getter setter
	public boolean isDestructable() {
		return isDestructable;
	}
	
	public void setDestructable(boolean isIndestructable) {
		this.isDestructable = isIndestructable;
	}
}
