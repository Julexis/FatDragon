package jeu;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import timer.Timer;
import timer.TimerEvent;
import timer.TimerEventGetGrainAtRandom;
import ObjetsInteractif.*;
import animal.Joueur;
import animal.SpawnType;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;

public class Jeu extends BasicGame {
	
	//Jeu principale
	private TiledMap[] maps;
	private TiledMap mapToRender;
	private int indexCalque;
	private Joueur joueur;
	private int tileSize;
	private int hauteur;
	private int largeur;
	private ObjetInteractifDragon drakeDrake;
	private ObjetInteractifJardin jardinGarden;
	private ObjetInteractifLac lakeLake;
	private Image fondMessage;
	private TimerEvent seedGenerator;
	private TrueTypeFont fonty;
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
		if(drakeDrake.isDead())
		{
			fondMessage.draw(25,25,350,350);
			fonty.drawString(30, 200, "Vous avez perdu :( relancez le jeu pour réassayez");
		}
		else if(drakeDrake.getHeight()>=drakeDrake.getmaxHeight())
		{
			fondMessage.draw(25,25,350,350);
			fonty.drawString(30, 200, "Vous êtes un WINNER, votre dragon c'est maintenant un big fat dragon");
		}
		else
		{
		if(mapToRender==maps[MAPS.DRAGON.toInt()])
		{
			drakeDrake.drawDragon();
		}
		joueur.drawMouvement();
		
		
		if(mapToRender==maps[MAPS.JARDIN.toInt()])
		{
			jardinGarden.afficherPlants();
			if(joueur.getInvent().isAffiche())
			{
				jardinGarden.getInventaireJardin().Affiche();
				
			}
			
		}
		joueur.drawInvent();
		if(joueur.getListeInteractionEnCours()!=null)
		{
		joueur.drawOptions();
		}
		drakeDrake.afficheLesBar();
		}
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		//Création du joueur
		this.joueur=new Joueur(5, 16, 0.2f, 16);
		//Création des objet à intéragir
		seedGenerator = new TimerEventGetGrainAtRandom(joueur.getInvent());
		drakeDrake=new ObjetInteractifDragon(joueur);
		lakeLake=new ObjetInteractifLac();
		jardinGarden=new ObjetInteractifJardin(joueur.getInvent());
		//Tableau des 4 maps
		joueur.setInventJardin(jardinGarden.getInventaireJardin());
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
		jardinGarden.getInventaireJardin().setSelect(false);
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
		Font awtFont = new Font("Times New Roman", Font.BOLD, 15);
		fonty = new TrueTypeFont( awtFont, false);
		fondMessage=new Image("./ressourceJeu/fondInventaire.png");
	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException
	{
		//On sélection les input du joueur
		joueur.InputJoueur(arg0.getInput());
		//On vérifie si le joueur change de map
		changementMap();
		Timer.increment();

	}
		
	public void changementMap()
	{
		//Ici on vérifie les changement de map  et on effectue d'autre changement en conséquence
		if(mapToRender==maps[MAPS.LAC.toInt()])
		{
			if(joueur.getEmplacementX()>= largeur-1)
			{
				joueur.setEmplacementX(1);//On remet l'emplacement du bon côté
				mapToRender=maps[MAPS.FORET.toInt()];//
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
				joueur.setInJardin(false);
				joueur.resetInvent();
			}
			else if(joueur.getEmplacementX() <=0.5f)
			{
				joueur.setEmplacementX(largeur-1);
				mapToRender=maps[MAPS.DRAGON.toInt()];
				changerMapJoueur(mapToRender);
				joueur.setInJardin(false);
				joueur.resetInvent();
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
			joueur.setInJardin(true);
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
	
	public void SpawnSomething(int minNumberOfSpawns, int maxNumberOfSpawns, SpawnType type)
	{
		int nombreDeSpawn = ThreadLocalRandom.current().nextInt(minNumberOfSpawns, maxNumberOfSpawns + 1);
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < nombreDeSpawn; i++)
		{
			do
			{
				x = ThreadLocalRandom.current().nextInt(0, 20);
				y = ThreadLocalRandom.current().nextInt(0, 20);
			}while(maps[MAPS.FORET.toInt()].getTileId(x, y, maps[MAPS.FORET.toInt()].getLayerIndex("bloquer"))!=0);//Put tileIsNotEmpty condition
			
			switch(type)
			{
			case seed:
				SpawnSeed(x, y);
				break;
			case phacochere:
				SpawnPhacochere(x, y);
				break;
			}
		}
	}
	
	private void SpawnSeed(int x, int y)
	{
		
	}
	
	private void SpawnPhacochere(int x, int y)
	{
		
	}
}
	
