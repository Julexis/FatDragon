package item;

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
		dureDeVie = 205;
		isRotten = false;
		isInInvent = false;
		
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
