package objetsInteractif;

import item.Item;

public class Interaction {
	protected ObjetInteractif structure;
	
	public Interaction(ObjetInteractif o)
	{
		structure = o;
	}
	
	public void run(Item i)
	{
		//Surdéfinir
	}
}
