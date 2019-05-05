package item;

import org.newdawn.slick.*;

public class Inventaire {

	private Item[] items=new Item[8];
	private Image imageFond;
	private Image caseInventaire;
	private Image imageContour;
	private boolean isAffiche;
	private int emplacementXimageFond,emplacementYimageFond,sizeImageFond;
	private int sizeCaseInventaire;
	private int selectionX,selectionY;
	private int sizeContourCase;
	public int getSelectionX() {
		return selectionX;
	}

	public void setSelectionX(int selectionX) {
		this.selectionX = selectionX;
	}

	public int getSelectionY() {
		return selectionY;
	}

	public void setSelectionY(int selectionY) {
		this.selectionY = selectionY;
	}

	public Inventaire(Image imageFond, Image caseInventaire, Image imageContour) {
		super();
		this.imageFond = imageFond;
		this.caseInventaire = caseInventaire;
		this.imageContour = imageContour;
		emplacementXimageFond=110;
		emplacementYimageFond=110;
		sizeImageFond=200;
		sizeCaseInventaire=50;
		sizeContourCase=60;
	}

	public void actualiser()
	{
		if(isAffiche)
		{
			imageFond.draw(100,200);
			
		}
	}
	public Image getImageFond() {
		return imageFond;
	}

	public void setImageFond(Image imageFond) {
		this.imageFond = imageFond;
	}

	public boolean isAffiche() {
		return isAffiche;
	}

	public void setAffiche(boolean isAffiche) {
		this.isAffiche = isAffiche;
	}
	public void Affiche()
	{
		imageFond.draw(emplacementXimageFond,emplacementYimageFond,sizeImageFond ,sizeImageFond);
		imageContour.draw(5+emplacementXimageFond+65*selectionX,5+emplacementYimageFond+65*selectionY,sizeContourCase,sizeContourCase);
		for (int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				caseInventaire.draw((emplacementXimageFond+65*i)+10,(emplacementYimageFond+65*j)+10,sizeCaseInventaire,sizeCaseInventaire);
			}
		}
		
	}
}
