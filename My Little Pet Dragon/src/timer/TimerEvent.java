package timer;

//Les TimerEvent event sont les evenement qui sont activer par le timer
public class TimerEvent {

	public TimerEvent()
	{
		Timer.addEventListe(this);
	}
	
	//doit être appelé lorsque l'objet du TimerEvent est débarrassé.
	//autrement, une quantité infini de graines font faire appelé le trigger en continue
	public void die()
	{
		Timer.removeEventListe(this);
	}
	
	public void trigger(){/*Override this*/}
}
