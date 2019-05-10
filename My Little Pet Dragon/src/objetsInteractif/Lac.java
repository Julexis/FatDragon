package ObjetsInteractif;

import java.util.ArrayList;
import Interaction.*;

public class Lac extends ObjetInteractif {

	public Lac()
	{
		RemplirSceau i = new RemplirSceau();
		
		listeInteraction.add(i);
	}
}
