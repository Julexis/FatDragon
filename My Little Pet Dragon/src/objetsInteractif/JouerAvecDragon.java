package objetsInteractif;

import item.Item;

public class JouerAvecDragon extends Interaction{

	private Dragon drag;
	
	public JouerAvecDragon(ObjetInteractif o)
	{
		super(o);
		drag = (Dragon) o;
	}
	
	@Override
	public void run(Item i)
	{
		drag.playWithDragon();
	}
}
