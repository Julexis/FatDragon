package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import timer.TimerEvent;
import timer.VieillirGraine;

//Trouver dans la forêt. Peut être planter dans le jardin.
public class Graine extends Item{
	
	private TimerEvent timerEvent;
	private int dureDeVie;
	private boolean isRotten;
	private boolean isInInvent;
	private grainType type;
	
	
	public void Vieillir()
	{
		if (!isInInvent && !isRotten)
		{
			dureDeVie--;
			if (dureDeVie == 0) 
			{
				isRotten = true;
			}
		}
	}


	public boolean isInInvent() {
		return isInInvent;
	}

	public void setInInvent(boolean isInInvent) {
		this.isInInvent = isInInvent;
	}

	public Graine(grainType type)
	{
		timerEvent = new VieillirGraine(this);
		
		this.type = type;
		try {
				switch(type)//Initialise le legume en fonction de la sorte de grain
				{
				case blue:
					setImage(new Image ("./imagesItem/GraineBleue.png"));
					break;
				case red:
					setImage(new Image ("./imagesItem/GraineRouge.png"));
					break;
				case green:
					setImage(new Image ("./imagesItem/GrainVerte.png"));
					break;
				default:
					setImage(new Image ("./imagesItem/GraineJaune.png"));
				}
			}
			catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	//getter setter
	public grainType getType() {
		return type;
	}
	
	public void setType(grainType type) {
		this.type = type;
	}

	public int getDureDeVie() {
		return dureDeVie;
	}
}
