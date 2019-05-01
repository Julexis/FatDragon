package objetsInteractif;

import item.*;

public class LaverDragon extends Interaction{

	private Dragon drag;
	
	public LaverDragon(ObjetInteractif o)
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
