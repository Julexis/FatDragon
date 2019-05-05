package jeu;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import ObjetsInteractif.*;
import animal.Joueur;
public class Jeu extends BasicGame {
	
	
	private TiledMap[] maps;
	private TiledMap mapToRender;
	private int indexCalque;
	private Joueur joueur;
	private Image imageJoueur;
	private int tileSize;
	private float maxY;
	private float maxX;
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
		arg1.scale(3, 2.25f);
		mapToRender.render(0, 0);
		joueur.drawMouvement();
		joueur.drawInvent();
		joueur.drawOptions();
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		this.joueur=new Joueur(5, 16, 0.2f, 16);
		drakeDrake=new Dragon();
		lakeLake=new Lac();
		jardinGarden=new Jardin();
		maps=new TiledMap[4];
		try {
			maps[MAPS.LAC.toInt()] = new TiledMap("./maps/CarteLac.tmx");
			maps[MAPS.DRAGON.toInt()]=new TiledMap("./maps/AreaDragon.tmx");
			maps[MAPS.FORET.toInt()]=new TiledMap("./maps/Foret.tmx");
			maps[MAPS.JARDIN.toInt()]=new TiledMap("./maps/Jardin.tmx");
			
		} catch (Exception e) {
			Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, e);
		}
		tileSize=20;
		
		mapToRender=maps[MAPS.LAC.toInt()];
		changerMapJoueur(mapToRender);
		maxY=arg0.getHeight();
		maxX=arg0.getWidth();
		imageJoueur=joueur.getImage();
		hauteur = 20;
		largeur = 20;
		
		joueur.setObjetEnCours(lakeLake);
		joueur.setListeInteractionEnCours(lakeLake.getListeInteraction());
		
	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException
	{
		// TODO Auto-generated method stub
		joueur.InputJoueur(arg0.getInput());
		changementMap();
		
	}
		
	public void changementMap()
	{
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
				joueur.setEmplacementY(0);
				mapToRender=maps[MAPS.DRAGON.toInt()];
				changerMapJoueur(mapToRender);
			}
		}
		else if(mapToRender == maps[MAPS.DRAGON.toInt()])
		{
			if(joueur.getEmplacementY() < 0)
			{
				joueur.setEmplacementY(hauteur - 1);
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
			if(joueur.getEmplacementY() <= 1)
			{
				joueur.setEmplacementY(hauteur - 1);
				mapToRender=maps[MAPS.FORET.toInt()];
				changerMapJoueur(mapToRender);
				
			}
			else if(joueur.getEmplacementX() < 1)
			{
				joueur.setEmplacementX(largeur-1);
				mapToRender=maps[MAPS.DRAGON.toInt()];
				changerMapJoueur(mapToRender);
			}
		}
	}
	public void changerMapJoueur(TiledMap map)
	{
		
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
			
		
		joueur.setMap(map);
		joueur.setCalqueBloquer(map.getLayerIndex("bloquer"));
		joueur.setCalqueInteragir(map.getLayerIndex("interagir"));
	}
	
	}
	
