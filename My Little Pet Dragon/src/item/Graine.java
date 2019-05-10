package item;

public class Graine extends Item{
	
	private int dureDeVie;
	private boolean isInInvent;
	private grainType type;
	
	

	public void setDureDeVie(int dureDeVie) {
		this.dureDeVie = dureDeVie;
	}

	public boolean isInInvent() {
		return isInInvent;
	}

	public void setInInvent(boolean isInInvent) {
		this.isInInvent = isInInvent;
	}

	public Graine(grainType type)
	{
		this.type = type;
		
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
