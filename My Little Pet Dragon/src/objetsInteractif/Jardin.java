package ObjetsInteractif;

import java.util.ArrayList;
import Interaction.*;

import item.*;

public class Jardin extends ObjetInteractif{
	
	private ArrayList<Plante> listePlante = new ArrayList<Plante>();

	
	public void putGraine(Graine g)
	{
		Plante p = new Plante(g.getType());
		listePlante.add(p);
	}
	
	public Legume harvest(int index)
	{
		Legume output = new Legume(listePlante.get(index).getType());
		
		
		
		return output;
	}
	
	public ArrayList<Plante> getListePlante() {
		return listePlante;
	}

	public void setListePlante(ArrayList<Plante> listePlante) {
		this.listePlante = listePlante;
	}
	
	public void growPlants()
	{
		for(Plante p: listePlante)
		{
			int comp = p.getNiveauDeCompletion()-1;
			
			if (comp < 0)
			{
				p.setNiveauDeCompletion(0);
			}
			else
			{
				p.setNiveauDeCompletion(comp);
			}
		}
	}
}
