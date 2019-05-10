package timer;

import java.util.ArrayList;

public class Timer {
	static int tick = 0;
	static ArrayList<TimerEvent> eventListe = new ArrayList<TimerEvent>();
	
	
	public static void increment()
	{
		tick = (tick + 1) % 6;
		
		if (tick == 0)
		{
			for (TimerEvent t : eventListe)
			{
				t.trigger();
			}
		}
	}
	
	public static void addEventListe(TimerEvent t)
	{
		eventListe.add(t);
	}
	
	public static void removeEventListe(TimerEvent t)
	{
		eventListe.remove(t);
	}
	
	public static ArrayList<TimerEvent> getListe()
	{
		return eventListe;
	}
	
	public static int getTick()
	{
		return tick;
	}
}
