package timer;

import java.util.ArrayList;

public class Timer {
	static int tick;
	static ArrayList<TimerEvent> eventListe;
	
	public Timer()
	{
		tick = 0;
	}
	
	public void increment()
	{
		tick = (tick + 1) % 60;
		
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
