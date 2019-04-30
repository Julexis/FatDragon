package jeu;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;

import animal.Joueur;


public class main {

	public  main()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		int largeurAffichage = 1200;
		int hauteurAffichage = 900;
		boolean siPleinEcran = false;
		
		try {
			
			
			AppGameContainer app = new AppGameContainer(new Jeu("My little pet Dragon"));
			
			app.setDisplayMode(largeurAffichage, hauteurAffichage, siPleinEcran);
			app.setTargetFrameRate(60);
			app.setShowFPS(true);
			app.start();
			
		}catch (SlickException ex) {
			Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);	
		}
	}

}
