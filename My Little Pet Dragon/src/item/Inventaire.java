package item;

import org.newdawn.slick.*;

public class Inventaire {

	private Item[] items=new Item[8];
	private Image imageFond;
	private Image caseInventaire;
	private Image imageContour;
	
	public Inventaire(Image imageFond, Image caseInventaire, Image imageContour) {
		super();
		this.imageFond = imageFond;
		this.caseInventaire = caseInventaire;
		this.imageContour = imageContour;
	}

	
}
