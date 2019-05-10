package timer;

import ObjetsInteractif.Jardin;

//TimerEvent qui appel la fonction pour faire pousser les plantes
public class VieillirJardin extends TimerEvent{

	Jardin jardin;
	
	public VieillirJardin(Jardin jardin)
	{
		super();
		this.jardin = jardin;
	}

	@Override
	public void trigger()
	{
		jardin.growPlants();
	}
}
