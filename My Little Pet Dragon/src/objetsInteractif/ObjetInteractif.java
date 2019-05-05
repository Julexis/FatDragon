package ObjetsInteractif;

import java.util.ArrayList;
import Interaction.*;

public class ObjetInteractif {
	protected ArrayList<Interaction> listeInteraction = new ArrayList<Interaction>();

	public void run()
	{
		//Redéfinir dans chaque sous-classes
	}
	
	public ArrayList<Interaction> getListeInteraction() {
		return listeInteraction;
	}

	public void setListeInteraction(ArrayList<Interaction> listeInteraction) {
		this.listeInteraction = listeInteraction;
	}
}
