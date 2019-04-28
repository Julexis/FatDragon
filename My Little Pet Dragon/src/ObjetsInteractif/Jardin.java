package ObjetsInteractif;

import java.util.ArrayList;

import item.*;

public class Jardin {
	
	private ArrayList<Plante> listePlante;

	public void putGraine(Graine g)
	{
		Plante p = new Plante(g.getType());
		listePlante.add(p);
		
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
