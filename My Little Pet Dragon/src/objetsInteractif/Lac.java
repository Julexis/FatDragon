package objetsInteractif;

import java.util.ArrayList;

public class Lac extends ObjetInteractif {

	public Lac()
	{
		NourrirDragon i = new NourrirDragon(this);
		
		listeInteraction.add(i);
	}
}
