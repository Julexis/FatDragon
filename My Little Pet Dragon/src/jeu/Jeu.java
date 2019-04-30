package jeu;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import animal.Joueur;
import ObjetsInteractif.MAPS;
public class Jeu extends BasicGame {
	
	
	private TiledMap[] maps;
	private TiledMap mapToRender;
	private int indexCalque;
	private Joueur joueur;
	private Image imageJoueur;
	private int tileSize;
	private float maxY;
	private float maxX;
	public Jeu(String title) {
		super(title);
		
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		arg1.scale(3, 2.25f);
		mapToRender.render(0, 0);
		imageJoueur.draw(joueur.getEmplacementX()*tileSize,joueur.getEmplacementY()*tileSize,joueur.getSize(),joueur.getSize());
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		this.joueur=new Joueur(5, 16, 0.2f, 25);
		maps=new TiledMap[4];
		try {
			maps[MAPS.LAC.toInt()] = new TiledMap("./maps/CarteLac.tmx");
			maps[MAPS.DRAGON.toInt()]=new TiledMap("./maps/AreaDragon.tmx");
			maps[MAPS.FORET.toInt()]=new TiledMap("./maps/Foret.tmx");
		} catch (Exception e) {
			Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, e);
		}
		tileSize=20;
		
		mapToRender=maps[MAPS.LAC.toInt()];
		changerMapJoueur(mapToRender);
		maxY=arg0.getHeight();
		maxX=arg0.getWidth();
		imageJoueur=joueur.getImage();
		
		
	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException
	{
		// TODO Auto-generated method stub
		joueur.deplacement(arg0.getInput());
		changementMap();
		
	}
		
	public void changementMap()
	{
		if(mapToRender==maps[MAPS.LAC.toInt()])
		{
			if(joueur.getEmplacementX()>=19)
			{
				joueur.setEmplacementX(0);
				mapToRender=maps[MAPS.FORET.toInt()];
				changerMapJoueur(mapToRender);
				
			}
			//else if(joueur.getEmplacementY())
		}
	}
	public void changerMapJoueur(TiledMap map)
	{
		joueur.setMap(map);
		joueur.setCalqueBloquer(map.getLayerIndex("bloquer"));
	}
	}
	
