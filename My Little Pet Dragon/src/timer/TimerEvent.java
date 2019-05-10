package timer;

public class TimerEvent {

	public TimerEvent()
	{
		Timer.addEventListe(this);
	}
	
	public void die()
	{
		Timer.removeEventListe(this);
	}
	
	public void trigger(){/*Override this*/}
}
