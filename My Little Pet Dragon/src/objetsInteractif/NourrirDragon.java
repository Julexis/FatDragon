package objetsInteractif;

import item.*;

public class NourrirDragon extends Interaction{
	
	private Dragon drag;
	
	public NourrirDragon(ObjetInteractif o)
	{
		super(o);
		drag = (Dragon) o;
	}
	
	@Override
	public void run(Item i)
	{
		try
		{
			Food f = (Food) i;
			drag.feedDragon(f);
		}
		catch (Exception e)
		{
			//todo code pour les item i non-food
		}
	}
}
