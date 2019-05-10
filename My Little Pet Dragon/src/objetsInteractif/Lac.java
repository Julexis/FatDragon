package ObjetsInteractif;

import java.util.ArrayList;
import Interaction.*;

public class Lac extends ObjetInteractif {

	public Lac()
	{
		InteractionRemplirSceau i = new InteractionRemplirSceau(this);
		
		listeInteraction.add(i);
	}
}
