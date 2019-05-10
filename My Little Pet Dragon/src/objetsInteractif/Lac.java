package ObjetsInteractif;

import java.util.ArrayList;
import Interaction.*;

//Objet qui permet l'interaction du remplissage de sceau
public class Lac extends ObjetInteractif {

	public Lac()
	{
		RemplirSceau i = new RemplirSceau();
		
		listeInteraction.add(i);
	}
}
