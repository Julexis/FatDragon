package item;

import org.newdawn.slick.Image;

//class abstraite d'item
abstract public class Item {
	private boolean isDestructable = true;//Determine si l'objet peut être défausser par le joueur
	//(en résumé, tout sauf le sceau!)
	
	private static Image image;//image de l'objet
	
	//getter setter
	public static Image getImage() {
		return image;
	}
	public static void setImage(Image image) {
		Item.image = image;
	}
	
	//getter setter
	public boolean isDestructable() {
		return isDestructable;
	}
	
	public void setDestructable(boolean isIndestructable) {
		this.isDestructable = isIndestructable;
	}
}
