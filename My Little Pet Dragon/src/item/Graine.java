package item;

public class Graine extends Item{
	private grainType type;
	
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

	
}
