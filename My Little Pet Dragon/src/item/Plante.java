package item;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

//Plante qui pousse dans le jardin. Peuvent être récolter lorsque prête.
public class Plante extends Item{
	private grainType type;
	private float niveauDeCompletion;
	private float completionMax;
	private Image imagePousser;
	public Plante(grainType type)
	{
		this.type = type;//set l'image en fonction de la sorte
		try {
			switch(type)
			{
			case yellow:
				niveauDeCompletion = 100;
				completionMax=100;
				setImage(new Image("./imagesItem/arbreJaune.png"));
				setImagePousser(new Image("./imagesItem/applePie.png"));
				break;
			case blue:
				niveauDeCompletion = 60;
				completionMax=60;
				setImage(new Image("./imagesItem/arbreBleu.png"));
				setImagePousser(new Image("./imagesItem/gingerAle.png"));
				break;
			case red:
				niveauDeCompletion = 75;
				completionMax=75;
				setImage(new Image("./imagesItem/arbreOrange.png"));
				setImagePousser(new Image("./imagesItem/hotdog.png"));
				break;
			case green:
				niveauDeCompletion = 20;
				completionMax=20;
				setImage(new Image("./imagesItem/arbreVert.png"));
				setImagePousser(new Image("./imagesItem/orange.png"));
				break;
			} 
		}catch (SlickException e) {
		e.printStackTrace();
		}
	}
	
	public Image getImagePousser() {
		return imagePousser;
	}

	public void setImagePousser(Image imagePousser) {
		this.imagePousser = imagePousser;
	}

	//getter setter
	public grainType getType() {
		return type;
	}
	public float getCompletionMax() {
		return completionMax;
	}

	public void setCompletionMax(float completionMax) {
		this.completionMax = completionMax;
	}

	public void setType(grainType type) {
		this.type = type;
	}
	public float getNiveauDeCompletion() {
		return niveauDeCompletion;
	}
	public void setNiveauDeCompletion(float niveauDeCompletion) {
		this.niveauDeCompletion = niveauDeCompletion;
	}
}
