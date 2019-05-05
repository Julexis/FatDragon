package item;

import org.newdawn.slick.*;

public class Inventaire {

	private Item[] items=new Item[8];
	private Image imageFond;
	private Image caseInventaire;
	private Image imageContour;
	private boolean isAffiche;
	private int emplacementXimageFond,emplacementYimageFond,hauteurImageFond, largeurImageFond;
	private int sizeCaseInventaire;
	private int selectionX,selectionY;
	private int sizeContourCase;
	private int row;
	private int line; 
	

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

	public Inventaire(Image imageFond, Image caseInventaire, Image imageContour, int row, int line, int emplacementXimageFond, int emplacementYimageFond) {
		super();
		this.imageFond = imageFond;
		this.caseInventaire = caseInventaire;
		this.imageContour = imageContour;
		this.emplacementXimageFond = emplacementXimageFond;
		this.emplacementYimageFond = emplacementYimageFond;
		sizeContourCase = 30;
		sizeCaseInventaire=25;
		this.line=line;
		this.row=row;
		hauteurImageFond = (row * sizeCaseInventaire+25)+(row-3)*8;
		largeurImageFond = (line * sizeCaseInventaire+25)+(line-3)*8;
		
		
	}


	public int getEmplacementYimageFond() {
		return emplacementYimageFond;
	}

	public void setEmplacementYimageFond(int emplacementYimageFond) {
		this.emplacementYimageFond = emplacementYimageFond;
	}

	public int getHauteurImageFond() {
		return hauteurImageFond;
	}

	public void setHauteurImageFond(int hauteurImageFond) {
		this.hauteurImageFond = hauteurImageFond;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
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
		
		imageFond.draw(emplacementXimageFond, emplacementYimageFond, largeurImageFond, hauteurImageFond);
		imageContour.draw(2.5f+emplacementXimageFond+32.5f*selectionX,2.5f+emplacementYimageFond+32.5f*selectionY,sizeContourCase,sizeContourCase);
		for (int i=0;i<line;i++)
		{
			for(int j=0;j<row;j++)
			{
				caseInventaire.draw((emplacementXimageFond+32.5f*i)+5,(emplacementYimageFond+32.5f*j)+5,sizeCaseInventaire,sizeCaseInventaire);
			}
		}
		
	}
}
