package timer;

import ObjetsInteractif.Jardin;

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
