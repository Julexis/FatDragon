package timer;

import item.Graine;

//TimerEvent qui fait increment la valeur de pouriture d'une graine au sol qui reste trop long temps sans être prise
public class VieillirGraine extends TimerEvent{

	Graine graine;//Pointeur vers la graine en question
	
	public VieillirGraine(Graine graine)
	{
		this.graine = graine;
	}
	
	@Override
	public void trigger()
	{
		
		graine.Vieillir();//method de la graine qui incrémente et despawn les graines par terre
		
	}
}
