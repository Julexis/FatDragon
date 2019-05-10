package jeu;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import ObjetsInteractif.*;
import animal.Joueur;
public class Jeu extends BasicGame {
	
	//Jeu principale
	private TiledMap[] maps;
	private TiledMap mapToRender;
	private int indexCalque;
	private Joueur joueur;
	private int tileSize;
	private int hauteur;
	private int largeur;
	private Dragon drakeDrake;
	private Jardin jardinGarden;
	private Lac lakeLake;
	public Jeu(String title) {
		super(title);
		
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		//Lors de l'affichage on scale la map et l'affichage pour être à l'échelle de la fenêtre
		arg1.scale(3, 2.25f);
		//On affiche la map actuelle
		mapToRender.render(0, 0);
		//On affiche le joueur, l'inventaire et les options
		joueur.drawMouvement();
		joueur.drawInvent();
		if(joueur.getListeInteractionEnCours()!=null)
		{
		joueur.drawOptions();
		}
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		//Création du joueur
		this.joueur=new Joueur(5, 16, 0.2f, 16);
		//Création des objet à intéragir
		drakeDrake=new Dragon();
		lakeLake=new Lac();
		jardinGarden=new Jardin(joueur.getInvent());
		//Tableau des 4 maps
		maps=new TiledMap[4];
		try {
			maps[MAPS.LAC.toInt()] = new TiledMap("./maps/CarteLac.tmx");
			maps[MAPS.DRAGON.toInt()]=new TiledMap("./maps/AreaDragon.tmx");
			maps[MAPS.FORET.toInt()]=new TiledMap("./maps/Foret.tmx");
			maps[MAPS.JARDIN.toInt()]=new TiledMap("./maps/Jardin.tmx");
			
		} catch (Exception e) {
			Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, e);
		}
		//On affiche la taille d'une tile
		tileSize=20;
		//La première map à afficher est la map Lac
		mapToRender=maps[MAPS.LAC.toInt()];
		//Le joueur est sur la map à afficher
		changerMapJoueur(mapToRender);
		//On met en place la hauteur et la largeur en tile
		hauteur = 20;
		largeur = 20;
		//L'objet en cours est lakelake pour le jouer
		joueur.setObjetEnCours(lakeLake);
		//On set la liste d'interaction pour le joueur (au lac) 
		joueur.setListeInteractionEnCours(lakeLake.getListeInteraction());
		
	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException
	{
		//On sélection les input du joueur
		joueur.InputJoueur(arg0.getInput());
		//On vérifie si le joueur change de map
		changementMap();
		
	}
		
	public void changementMap()
	{
		//Ici on vérifie les changement de map  et on effectue d'autre changement en conséquence
		if(mapToRender==maps[MAPS.LAC.toInt()])
		{
			if(joueur.getEmplacementX()>= largeur-1)
			{
				joueur.setEmplacementX(1);
				mapToRender=maps[MAPS.FORET.toInt()];
				changerMapJoueur(mapToRender);		
			}
			else if(joueur.getEmplacementY()>= 19)
			{
				joueur.setEmplacementY(1);
				mapToRender=maps[MAPS.DRAGON.toInt()];
				changerMapJoueur(mapToRender);
			}
		}
		else if(mapToRender == maps[MAPS.DRAGON.toInt()])
		{
			if(joueur.getEmplacementY() < 0)
			{
				joueur.setEmplacementY(hauteur - 1f);
				mapToRender=maps[MAPS.LAC.toInt()];
				changerMapJoueur(mapToRender);
			}
			else if(joueur.getEmplacementX() >=largeur-1)
			{
				joueur.setEmplacementX(1);
				mapToRender=maps[MAPS.JARDIN.toInt()];
				changerMapJoueur(mapToRender);
			}

			
		}
		else if(mapToRender == maps[MAPS.FORET.toInt()])
		{
			if(joueur.getEmplacementY() >= 19)
			{
				joueur.setEmplacementY(1);
				mapToRender=maps[MAPS.JARDIN.toInt()];
				changerMapJoueur(mapToRender);
			}
			else if(joueur.getEmplacementX() <= 0.8f)
			{
				joueur.setEmplacementX(largeur - 1);
				mapToRender=maps[MAPS.LAC.toInt()];
				changerMapJoueur(mapToRender);
			}
		}
		else if(mapToRender == maps[MAPS.JARDIN.toInt()])
		{
			if(joueur.getEmplacementY() <= 0.8f)
			{
				joueur.setEmplacementY(hauteur - 1);
				mapToRender=maps[MAPS.FORET.toInt()];
				changerMapJoueur(mapToRender);
				
			}
			else if(joueur.getEmplacementX() <=0.5f)
			{
				joueur.setEmplacementX(largeur-1);
				mapToRender=maps[MAPS.DRAGON.toInt()];
				changerMapJoueur(mapToRender);
			}
		}
	}
	public void changerMapJoueur(TiledMap map)
	{
	//Change la map du joueur, les interactions et les objets en cours	
		if(map==maps[MAPS.DRAGON.toInt()])
		{
			joueur.setListeInteractionEnCours(drakeDrake.getListeInteraction());
			joueur.setObjetEnCours(drakeDrake);
		}
		else if(map==maps[MAPS.LAC.toInt()])
		{
			joueur.setListeInteractionEnCours(lakeLake.getListeInteraction());
			joueur.setObjetEnCours(lakeLake);
		}
		else if(map==maps[MAPS.JARDIN.toInt()])
		{
			joueur.setListeInteractionEnCours(jardinGarden.getListeInteraction());
			joueur.setObjetEnCours(jardinGarden);
		}
			
		else if(map==maps[MAPS.FORET.toInt()])
		{
			joueur.setListeInteractionEnCours(null);
			joueur.setObjetEnCours(null);
		}
		joueur.setChoixInteractionActive(false);
		joueur.setMap(map);
		joueur.setCalqueBloquer(map.getLayerIndex("bloquer"));
		joueur.setCalqueInteragir(map.getLayerIndex("interagir"));
	}
	
	}
	
