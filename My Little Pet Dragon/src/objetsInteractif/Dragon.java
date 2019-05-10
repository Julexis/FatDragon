package ObjetsInteractif;

import item.*;
import timer.TimerEvent;
import timer.VeillirDragon;

import java.awt.Font;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import Interaction.*;
import animal.Joueur;

public class Dragon extends ObjetInteractif {
	private float hungerMeter = 100;//100 is full and 0 is dead
	private final int maxHunger = 100;
	private float happiness = 100;
	private final int maxHappiness = 100;
	private float cleanliness = 100;
	private final int maxCleanliness = 100;
	Image imageDragon;
	Image[] bars;
	private int growRate = 10;
	private int height = 30;
	private TimerEvent timerEvent;
	private final int maxHeight = 400;
	private Joueur joueur;
	
	
	private boolean isDead = false;
	private boolean isDeadSad = false;
	private boolean isDeadDirty = false;
	private TrueTypeFont fonty;
	public Dragon(Joueur joueur)
	{
		timerEvent = new VeillirDragon(this);
		
		bars=new Image[3];
		
		listeInteraction.add(new NourrirDragon(this));
		listeInteraction.add(new JouerAvecDragon(this));
		listeInteraction.add(new LaverDragon(this));
		
		try {
			imageDragon=new Image("./images/dragon.png");
			bars[progressBar.BLEU.getBar()]=new Image("./imageBar/blue.png");
			bars[progressBar.JAUNE.getBar()]=new Image("./imageBar/yellow.png");
			bars[progressBar.ROUGE.getBar()]=new Image("./imageBar/red.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Font awtFont = new Font("Times New Roman", Font.BOLD, 10);
		fonty = new TrueTypeFont( awtFont, false);
		this.joueur = joueur;
		
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
		if (hungerMeter - 0.2f > 0)
		{
			hungerMeter -= 0.2f;
		}
		else
		{
			hungerMeter = 0;
			isDead = true;
		}
		
		//Diminish happiness
		if (happiness - 0.1f > 0)
		{
			happiness -= 0.1f;
		}
		else
		{
			happiness = 0;
			isDeadSad = true;
		}
		
		//Diminish Cleanliness
		if (cleanliness - 0.5f > 0)
		{
			cleanliness -= 0.5f;
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
	public void drawDragon()
	{
		imageDragon.draw(200-height/2,200-height/2,height,height);
	}
	public void afficheLesBar()
	{
		afficheUneBar(60,10,"Faim :",hungerMeter,bars[progressBar.ROUGE.getBar()]);
		afficheUneBar(60,30,"Propreté :",cleanliness,bars[progressBar.BLEU.getBar()]);
		afficheUneBar(60,50,"Bonheur :",happiness,bars[progressBar.JAUNE.getBar()]);
	}
	public void afficheUneBar(int x,int y,String text,float amount,Image image)
	{
		fonty.drawString(10, y, text);
		image.draw(x, y,amount,10);
	}
	public float getHunger() {
		return hungerMeter;
	}
	public void setHunger(int hunger) {
		this.hungerMeter = hunger;
	}
	public float getHappiness() {
		return happiness;
	}
	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}
	public float getCleanliness() {
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
	public void bloquerDragon()
	{
		if(joueur.getEmplacementX() >= getHeight())
	}

	public boolean isDeadSad() {
		return isDeadSad;
	}

	public void setDeadSad(boolean isDeadSad) {
		this.isDeadSad = isDeadSad;
	}

	public boolean isDeadDirty() {
		return isDeadDirty;
	}

	public void setDeadDirty(boolean isDeadDirty) {
		this.isDeadDirty = isDeadDirty;
	}
	
	
}
