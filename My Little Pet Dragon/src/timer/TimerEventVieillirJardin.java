package timer;

import ObjetsInteractif.ObjetInteractifJardin;

//TimerEvent qui appel la fonction pour faire pousser les plantes
public class TimerEventVieillirJardin extends TimerEvent{

	ObjetInteractifJardin jardin;
	
	public TimerEventVieillirJardin(ObjetInteractifJardin jardin)
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
