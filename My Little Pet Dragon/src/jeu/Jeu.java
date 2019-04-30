package jeu;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

import animal.Joueur;

public class Jeu extends BasicGame {
	
	
	private TiledMap map;
	private int indexCalque;
	private Joueur joueur;
	private Image imageJoueur;
	private int tileSize;
	public Jeu(String title) {
		super(title);
		
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		arg1.scale(3, 2.25f);
		map.render(0, 0);
		imageJoueur.draw(joueur.getEmplacementX()*tileSize,joueur.getEmplacementY()*tileSize,joueur.getSize(),joueur.getSize());
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		this.joueur=new Joueur(5, 16, 0.2f, 25);
		try {
			map = new TiledMap("./maps/MapCarte.tmx");
		} catch (Exception e) {
			Logger.getLogger(Jeu.class.getName()).log(Level.SEVERE, null, e);
		}
		tileSize=20;
		this.joueur.setMap(map);
		this.joueur.setCalqueBloquer(map.getLayerIndex("bloquer"));
		imageJoueur=joueur.getImage();
		
		
	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException
	{
		// TODO Auto-generated method stub
		joueur.deplacement(arg0.getInput());
		
	}
		
	}
	
