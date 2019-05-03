package item;

public class Legume extends Food{
	private vegieType type;
	
	public Legume(grainType t)
	{
		vegieType v = vegieType.applePie;
		switch(t)
		{
		case blue:
			v = vegieType.gingerale;
			break;
		case red:
			v = vegieType.hotdog;
			break;
		case green:
			v = vegieType.orange;
			break;
		}
		
		type = v;
	}
	
	public vegieType getType() {
		return type;
	}
	
	public void setType(vegieType type) {
		this.type = type;
	}

}

