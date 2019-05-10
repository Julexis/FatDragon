package Interaction;

import item.Item;
import ObjetsInteractif.*;
//Base pour les autres interactions possible. Les Objet interaction appelle une fonction et possède un texte à afficher
//Les interactions fonctionnent de manière similaire au pattern observer du TP3 et sont associé à l'objet avec lequel il est possible d'intéragie
abstract public class Interaction {
	protected ObjetInteractif structure;
	
	
	public void run(Item i){/*Surdéfinir*/}
	
	public String getMessage()
	{
		return "I'm a regular interraction. Try me!";
	}
}
