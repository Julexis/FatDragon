package Interaction;

import item.Item;
import ObjetsInteractif.*;

public class Interaction {
	protected ObjetInteractif structure;
	
	public Interaction(ObjetInteractif o)
	{
		structure = o;
	}
	
	public void run(Item i){/*Surdéfinir*/}
	
	public String getMessage()
	{
		return "I'm a regular interraction. Try me!";
	}
}
