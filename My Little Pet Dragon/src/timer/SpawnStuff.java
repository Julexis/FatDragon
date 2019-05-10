package timer;

import animal.SpawnType;
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
		jeu.SpawnSomething(1, 2, SpawnType.seed);
	}
}
