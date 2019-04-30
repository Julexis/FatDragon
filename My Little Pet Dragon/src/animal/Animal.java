package animal;



import org.newdawn.slick.*;

import org.newdawn.slick.tiled.TiledMap;

public class Animal {
	
	private TiledMap map;
	private float emplacementX;
	private float emplacementY;
	private int calqueBloquer;
	private float deplacement;
	private float size;
	private Image image;
	
	public Animal( float emplacementX, float emplacementY,  float deplacement, float size,Image image)
	{
		this.emplacementX = emplacementX;
		this.emplacementY = emplacementY;
		this.deplacement = deplacement;
		this.size = size;
		this.image=image;
		
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public TiledMap getMap() {
		return map;
	}

	public void setMap(TiledMap map) {
		this.map = map;
	}

	public float getEmplacementX() {
		return emplacementX;
	}

	public void setEmplacementX(float emplacementX) {
		this.emplacementX = emplacementX;
	}

	public float getEmplacementY() {
		return emplacementY;
	}

	public void setEmplacementY(float emplacementY) {
		this.emplacementY = emplacementY;
	}

	public int getCalqueBloquer() {
		return calqueBloquer;
	}

	public void setCalqueBloquer(int calqueBloquer) {
		this.calqueBloquer = calqueBloquer;
	}

	public float getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(float deplacement) {
		this.deplacement = deplacement;
	}
	public void draw()
	{
		this.image.draw(emplacementX*20, emplacementY*20,size,size);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
}
