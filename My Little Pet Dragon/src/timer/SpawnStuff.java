package timer;

import animal.SpawnType;
import jeu.Jeu;

//evenement qui appel les fonctions de spawn des objet
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
		jeu.SpawnSomething(1, 2, SpawnType.seed);//spawn 1 a 2 seed
	}
}
