package item;

public class Plante extends Item{
	private grainType type;
	private int niveauDeCompletion;//peut être de 0 a 100
	
	
	
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
