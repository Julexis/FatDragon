package timer;

import java.util.ArrayList;

//Class qui s'occupe de l'avancement du temps, et qui se charge des évènements relié au temps.
public class Timer {
	static int tick = 0;
	static ArrayList<TimerEvent> eventListe = new ArrayList<TimerEvent>();
	
	//Incrémente chaque update(60 fois par secondes, juste avant l'affichage)
	public static void increment()
	{
		tick = (tick + 1) % 5;
		
		if (tick == 0)
		{
			for (TimerEvent t : eventListe)
			{
				t.trigger();
			}
		}
	}
	
	//add un evenement à la liste
	public static void addEventListe(TimerEvent t)
	{
		eventListe.add(t);
	}
	
	//défausse un evenement de la liste
	public static void removeEventListe(TimerEvent t)
	{
		eventListe.remove(t);
	}
	
	//retourne la liste d'evenement
	public static ArrayList<TimerEvent> getListe()
	{
		return eventListe;
	}
	
	//retourne la valeur tick, qui est le numero du tick de la seconde
	public static int getTick()
	{
		return tick;
	}
}
