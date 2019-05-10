package ObjetsInteractif;

import item.*;
import Interaction.*;

public class Dragon extends ObjetInteractif {
	private int hungerMeter = 100;//100 is full and 0 is dead
	private final int maxHunger = 100;
	private int happiness = 100;
	private final int maxHappiness = 100;
	private int cleanliness = 100;
	private final int maxCleanliness = 100;
	
	private int growRate = 10;
	private int height = 30;
	
	private final int maxHeight = 400;

	private boolean isDead = false;
	private boolean isDeadSad = false;
	private boolean isDeadDirty = false;
	
	public Dragon()
	{
		listeInteraction.add(new NourrirDragon(this));
		listeInteraction.add(new JouerAvecDragon(this));
		listeInteraction.add(new LaverDragon(this));
	}
	
	public boolean growDragon()
	{
		boolean isFat = false;//Boolean that tells if the dragon is done growing
		
		//GrowRate set
		if (hungerMeter >= 80)
		{
			growRate = 13;
		}
		else if (hungerMeter >= 50)
		{
			growRate = 10;
		}
		else
		{
			growRate = 8;
		}
		
		//Grow
		if (height + growRate < maxHeight)
		{
			height += growRate;
		}
		else
		{
			height = maxHeight;
			isFat = true;
		}
		
		//Diminish hungerMeter
		if (hungerMeter - 5 > 0)
		{
			hungerMeter -= 5;
		}
		else
		{
			hungerMeter = 0;
			isDead = true;
		}
		
		//Diminish happiness
		if (happiness - 5 > 0)
		{
			happiness -= 5;
		}
		else
		{
			happiness = 0;
			isDeadSad = true;
		}
		
		//Diminish Cleanliness
		if (cleanliness - 5 > 0)
		{
			cleanliness -= 5;
		}
		else
		{
			cleanliness = 0;
			isDeadDirty = true;
		}
		
		return isFat;
	}
	
	public void feedDragon(Food f)
	{
		if (hungerMeter + f.getFoodValue() <= maxHunger)
		{
			hungerMeter += f.getFoodValue();
		}
		else
		{
			hungerMeter = maxHunger;
		}
		
	}
	
	public void playWithDragon()
	{
		if (happiness + 35 < maxHappiness)
		{
			happiness += 35;
		}
		else
		{
			happiness = maxHappiness;
		}
		//Ajouter une animation? faire un channeling? Sujet aux changements
	}
	
	public void washDragon()
	{
		cleanliness = maxCleanliness;
		//Dragon is tout propre :)
	}
	
	public int getHunger() {
		return hungerMeter;
	}
	public void setHunger(int hunger) {
		this.hungerMeter = hunger;
	}
	public int getHappiness() {
		return happiness;
	}
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	public int getCleanliness() {
		return cleanliness;
	}
	public void setCleanliness(int cleanliness) {
		this.cleanliness = cleanliness;
	}
	public int getGrowRate() {
		return growRate;
	}
	public void setGrowRate(int growRate) {
		this.growRate = growRate;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getmaxHeight() {
		return maxHeight;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
}
