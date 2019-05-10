package ObjetsInteractif;
//Couleur utiliser pour les progress BAr
public enum progressBar {
	   JAUNE(0),
	    BLEU(1),
	    ROUGE(2);

	    private int bar = 0;

	    progressBar(int bar)
	    {
	        this.bar=bar;
	    }
	    public int getBar()
	    {
	        return bar;
	    }

	
}
