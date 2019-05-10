package animal;

import java.util.ArrayList;

import org.newdawn.slick.*;
import java.awt.Font;
import org.newdawn.slick.tiled.TiledMap;

import Interaction.Interaction;
import ObjetsInteractif.ObjetInteractif;
import item.Inventaire;
import item.Sceau;
public class Joueur extends Animal{
	
	
	//Joueur Hérite d'animal, il intègre les déplacements par clavier et possède un inventaire et affiche aussi les interactions possible des lieux
	private int calqueInteragir;
	private Input inputJoueur;
	private Inventaire invent,inventJardin;
	
	public Inventaire getInventJardin() {
		return inventJardin;
	}

	public void setInventJardin(Inventaire inventJardin) {
		this.inventJardin = inventJardin;
	}

	private int size;
	
	private int optionChoisis;
	private ObjetInteractif objetEnCours;
	private ArrayList<Interaction> listeInteractionEnCours;
	private boolean interactionAffiche,choixInteractionActive;
	TrueTypeFont fonty;
	//private textField
	
	public Joueur(float emplacementX, float emplacementY, float deplacement, int size) throws SlickException {
		
		super(emplacementX,emplacementY,deplacement,size,new Image("./images/monSprite.png"));
		
		//Création de l'inventaire dans Joueur
		this.setCalqueInteragir(calqueInteragir);
		invent=new Inventaire(new Image("./ressourceJeu/fondInventaire.png"),new Image("./ressourceJeu/case.png"),new Image("./ressourceJeu/caseContour.png"),3,3,140,100);
		invent.setSelectionX(0);
		invent.setSelectionY(0);
		choixInteractionActive=false;
		invent.setSelect(true);
		
		//Création du fond pour la future liste d'interaction
		Font awtFont = new Font("Times New Roman", Font.BOLD, 10);
		fonty = new TrueTypeFont( awtFont, false);
		invent.addObjet(new Sceau());
	}

	public void deplacement(Input inputJoueur) {
		// La fonction gère les déplacement et empêche de dépasser les murs
		this.inputJoueur=inputJoueur;
		
		moving=true;
		if(this.inputJoueur.isKeyDown(Input.KEY_RIGHT))
		{
			if(getMap().getTileId((int)getEmplacementX()+1, (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementX(getEmplacementX() +getDeplacement()); 
				setDirection(Direction.RIGHT);
			}
		}
	
		else if(this.inputJoueur.isKeyDown(Input.KEY_LEFT))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementX(getEmplacementX() - getDeplacement());
				setDirection(Direction.LEFT);
			}
			
		}
		else if(this.inputJoueur.isKeyDown (Input.KEY_UP))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY(), getCalqueBloquer())==0)
			{
				setEmplacementY(getEmplacementY() - getDeplacement());
				setDirection(Direction.UP);
			}
			
		}
		else if(this.inputJoueur.isKeyDown(Input.KEY_DOWN))
		{
			if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY()+1, getCalqueBloquer())==0)
			{
				setEmplacementY(getEmplacementY() + getDeplacement());
				setDirection(Direction.DOWN);
			}
			
		}
		//Si il ne se déplace pas le booléen moving est à false
		else
		{
			moving=false;
		}
		
	}
	//Ici il y a la gestion des input
	public void InputJoueur(Input inputJoueur)
	{
		//Si il apuis sur E l'inventaire apparait ou disparait et on met à jour les options disponibles
		
		if(inputJoueur.isKeyPressed(Input.KEY_E))
		{
			invent.setAffiche(!invent.isAffiche());
			optionChoisis=0;
			//updateOptionListe();
	
		}
		//Si l'inventaire n'est pas afficher on gère les déplacement
		 if(!invent.isAffiche())
		{
			deplacement(inputJoueur);
		}
		 //Sinon on se déplace dans l'index de l'inventaire
		 else
		 {
			if(listeInteractionEnCours!=null)
			{
			 if(choixInteractionActive&&inputJoueur.isKeyPressed(Input.KEY_Z))
			 {
				 appelleFonction();
			 }
			 if(inputJoueur.isKeyPressed(Input.KEY_Z))
			 {
				 choixInteractionActive=!choixInteractionActive;
				 
			 }
			 if(choixInteractionActive&&inputJoueur.isKeyPressed(Input.KEY_X))
			 {
				 choixInteractionActive=false;
			 }
			}
			 if(!choixInteractionActive)
			 {
				 choixIndex(inputJoueur);
			 }
			
			 else
			 {
				 selectionOption(inputJoueur);
			 }
			
			 
		 }
		 inputJoueur.clearKeyPressedRecord();
	}
	public boolean isChoixInteractionActive() {
		return choixInteractionActive;
	}

	public void setChoixInteractionActive(boolean choixInteractionActive) {
		this.choixInteractionActive = choixInteractionActive;
	}

	//On affiche l'inventaire si l'inventaire est ouvert
	public void drawInvent()
	{
		if(invent.isAffiche())
		{
			invent.Affiche();
		}
		
	}
	
	//On choisis on déplace l'index et empêche de sortir de ce dernier en fonction des input du joueur
	public void choixIndex(Input inputJoueur)
	{
		this.inputJoueur=inputJoueur;
		if(this.inputJoueur.isKeyPressed(Input.KEY_RIGHT))
		{
			invent.setSelectionX(invent.getSelectionX()+1);
		}
		else if(this.inputJoueur.isKeyPressed(Input.KEY_LEFT))
		{
			
			invent.setSelectionX(invent.getSelectionX()-1);

		}
		else if(this.inputJoueur.isKeyPressed(Input.KEY_UP))
		{
			invent.setSelectionY(invent.getSelectionY()-1);

		}
		else if(this.inputJoueur.isKeyPressed(Input.KEY_DOWN))
		{
			invent.setSelectionY(invent.getSelectionY()+1);

		}
		if(invent.getSelectionX()>invent.getLine()-1)
		{
			invent.setSelectionX(invent.getLine()-1);
		}
		if(invent.getSelectionY()>invent.getRow()-1)
		{
			invent.setSelectionY(invent.getRow()-1);
		}
		if(invent.getSelectionX()<0)
		{
			invent.setSelectionX(0);
		}
		if(invent.getSelectionY()<0)
		{
			invent.setSelectionY(0);
		}
	}
	public Inventaire getInvent() {
		return invent;
	}
	public void afficheInventJardin()
	{
		
	}
	//La fonction doit définir si le joueur est sur un emplacement permettant d'intéragir ou non (non utiliser)
	public void updateOptionListe()
	{
		
		if(getMap().getTileId((int)getEmplacementX(), (int)getEmplacementY(),calqueInteragir)==2)
		{
			interactionAffiche=true;
		}
		else
		{
			interactionAffiche=false;
		}
	}
	//On va chercher les Option et on les affiche dans un menu contextuelle à côté de notre menu
	public void drawOptions()
	{
		if(invent.isAffiche())
		{
			invent.getImageFond().draw(10,invent.getEmplacementYimageFond(),120,100);
			int y=20;
			int valeurI=0;
			for(Interaction i:listeInteractionEnCours)
			{
				if(choixInteractionActive&&(valeurI==optionChoisis))
				{
					fonty.drawString(10, invent.getEmplacementYimageFond()+y, i.getMessage(), Color.red);
				}
				else
				{
				fonty.drawString(10, invent.getEmplacementYimageFond()+y, i.getMessage());
				
				}
				y+=20;
				valeurI++;
			}
		}
	}
	public void selectionOption(Input inputJoueur)
	{
		
		 if(this.inputJoueur.isKeyPressed (Input.KEY_UP))
			{
			 optionChoisis--;
			}
		else if(this.inputJoueur.isKeyPressed(Input.KEY_DOWN))
			{
			optionChoisis++;
			}
		if(optionChoisis>(listeInteractionEnCours.size())-1)
		{
			optionChoisis=listeInteractionEnCours.size()-1;
		}
		if(optionChoisis<0)
		{
			optionChoisis=0;
		}
	}
	public void appelleFonction()
	{
		if(invent.getItemSelect()!=null)
		{
		listeInteractionEnCours.get(optionChoisis).run(invent.getItemSelect());
		}
		choixInteractionActive=false;
	}
public ArrayList<Interaction> getListeInteractionEnCours() {
		
		return listeInteractionEnCours;
	}

	public void setListeInteractionEnCours(ArrayList<Interaction> listeInteractionEnCours) {
		this.listeInteractionEnCours = listeInteractionEnCours;
	}

	public void setInvent(Inventaire invent) {
		this.invent = invent;
	}

	public int getCalqueInteragir() {
		return calqueInteragir;
	}

	public void setCalqueInteragir(int calqueInteragir) {
		this.calqueInteragir = calqueInteragir;
	}
	public ObjetInteractif getObjetEnCours() {
		return objetEnCours;
	}

	public void setObjetEnCours(ObjetInteractif objetEnCours) {
		this.objetEnCours = objetEnCours;
	}

}
