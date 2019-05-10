package timer;

import jeu.Jeu;

public class SpawnStuff extends TimerEvent{

	Jeu jeu;
	
	public SpawnStuff(Jeu jeu)
	{
		super();
		this.jeu = jeu;
	}
	
	
	@Override
	public void trigger()
	{
		/*jeu.SpawnSeed(1, 3);
		jeu.SpawnPhacochere(0, 2);*/
	}
}
