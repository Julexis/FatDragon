package timer;

import item.Graine;
import item.Inventaire;
import item.grainType;

import java.util.concurrent.ThreadLocalRandom;

public class TimerEventGetGrainAtRandom extends TimerEvent{

	Inventaire inventaire;
	
	public TimerEventGetGrainAtRandom(Inventaire inventaire)
	{
		super();
		this.inventaire = inventaire;
	}
	
	public void trigger()
	{
		int randomNumber = ThreadLocalRandom.current().nextInt(1, 25+1);
		
		if (randomNumber == 25)
		{
			randomNumber = ThreadLocalRandom.current().nextInt(0, 5);
			grainType type;
			
			switch (randomNumber)
			{
			case 1:
				type = grainType.blue;
				break;
			case 2:
				type = grainType.green;
				break;
			case 3:
				type = grainType.yellow;
				break;
			default:
				type = grainType.red;
				break;
			}
			
			Graine graine = new Graine(type);
			inventaire.addObjet(graine);
		}
		
	}
}
