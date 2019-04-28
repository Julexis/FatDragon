package item;

public class Plante extends Item{
	private grainType type;
	private int niveauDeCompletion;
	
	
	public Plante(grainType type)
	{
		this.type = type;
		
		switch(type)
		{
		case yellow:
			niveauDeCompletion = 100;
			break;
		case blue:
			niveauDeCompletion = 60;
			break;
		case red:
			niveauDeCompletion = 75;
			break;
		case green:
			niveauDeCompletion = 20;
			break;
		}
	}
	public grainType getType() {
		return type;
	}
	public void setType(grainType type) {
		this.type = type;
	}
	public int getNiveauDeCompletion() {
		return niveauDeCompletion;
	}
	public void setNiveauDeCompletion(int niveauDeCompletion) {
		this.niveauDeCompletion = niveauDeCompletion;
	}
}
