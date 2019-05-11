package ObjetsInteractif;

import java.util.ArrayList;
import Interaction.*;

//Objet qui permet l'interaction du remplissage de sceau
public class ObjetInteractifLac extends ObjetInteractif {

	public ObjetInteractifLac()
	{
		InteractionRemplirSceau i = new InteractionRemplirSceau();
		
		listeInteraction.add(i);
	}
}
