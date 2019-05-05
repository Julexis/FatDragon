package ObjetsInteractif;

import java.util.ArrayList;
import Interaction.*;

public class Lac extends ObjetInteractif {

	public Lac()
	{
		NourrirDragon i = new NourrirDragon(this);
		
		listeInteraction.add(i);
	}
}
