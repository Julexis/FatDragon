package jeu;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.*;


public class main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//Lancement du jeu principal qui fait 1200 par 900
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
