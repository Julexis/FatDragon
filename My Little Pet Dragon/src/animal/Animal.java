package animal;



import org.newdawn.slick.*;

import org.newdawn.slick.tiled.TiledMap;
public class Animal {
	
	private TiledMap map;
	protected float emplacementX;
	protected float emplacementY;
	private int calqueBloquer;
	private float deplacement;
	private float size;
	protected Image image;
	protected Animation animUp,animDown,animRight,animLeft;
	protected Direction direction;
	protected boolean moving;
	public Animal( float emplacementX, float emplacementY,  float deplacement, float size,Image image)
	{
		this.emplacementX = emplacementX;
		this.emplacementY = emplacementY;
		this.deplacement = deplacement;
		this.size = size;
		this.image=image;
		animUp=getAnimation(3);
		animDown=getAnimation(0);
		animRight=getAnimation(2);
		animLeft=getAnimation(1);
		direction=Direction.UP;
		
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
		this.image.draw(emplacementX, emplacementY,size,size);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	private Animation getAnimation(int rowY)
	{
		int x,y,width, height;
		Animation anim = new Animation(false);
		for (int i = 0; i < 4; i++)
		{
			x=i*32;
			y=rowY*48;
			width=32;
			height=48;
			//System.out.println("x:"+x+",y:"+y);
			anim.addFrame(image.getSubImage(x, y, width, height), 200);
		}
		
		return anim;
	}
	
	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void drawMouvement()
	{
		if(moving)
		{
		switch (direction) 
		 {
	         case UP:
	             animUp.draw(emplacementX*20, emplacementY*20,size,size*1.5f);
	            animUp.update(20);
	             break;
	         case DOWN:
	             animDown.draw(emplacementX*20, emplacementY*20,size,size*1.5f);
	             animDown.update(20);
	             break;
	         case RIGHT:
	             animRight.draw(emplacementX*20, emplacementY*20,size,size*1.5f);     
	             animRight.update(20);
	             break;
	         case LEFT:
	             animLeft.draw(emplacementX*20, emplacementY*20,size,size*1.5f);
	             animLeft.update(20);
	             break;
	     }	
		
		}
		else
		{
			switch (direction) 
			 {
		         case UP:
		        	 animUp.setCurrentFrame(0);
		             animUp.draw(emplacementX*20, emplacementY*20,size,size*1.5f);
		           
		             break;
		         case DOWN:
		        	 animDown.setCurrentFrame(0);
		             animDown.draw(emplacementX*20, emplacementY*20,size,size*1.5f);
		              break;
		         case RIGHT:
		        	animRight.setCurrentFrame(0);
		             animRight.draw(emplacementX*20, emplacementY*20,size,size*1.5f);     
		             break;
		         case LEFT:
		        	 animLeft.setCurrentFrame(0);;
		             animLeft.draw(emplacementX*20, emplacementY*20,size,size*1.5f);
		            
		             break;
		     }	
		}
	}
}
