package item;

import org.newdawn.slick.Image;

public class Item {
	private boolean isDestructable = true;
	private static Image image;
	public static Image getImage() {
		return image;
	}
	public static void setImage(Image image) {
		Item.image = image;
	}
	
	public boolean isDestructable() {
		return isDestructable;
	}
	
	public void setDestructable(boolean isIndestructable) {
		this.isDestructable = isIndestructable;
	}
}
