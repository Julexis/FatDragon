package Interaction;

import item.Item;
import ObjetsInteractif.*;
//Base pour les autres interactions possible. Les Objet interaction appelle une fonction et possède un texte à afficher
public class Interaction {
	protected ObjetInteractif structure;
	
	
	public void run(Item i){/*Surdéfinir*/}
	
	public String getMessage()
	{
		return "I'm a regular interraction. Try me!";
	}
}
