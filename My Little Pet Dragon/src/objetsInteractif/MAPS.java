package ObjetsInteractif;

public enum MAPS {
LAC(0),
DRAGON(1),
FORET(2),
JARDIN(3);
	private int map=0;
	MAPS(int map)
	{
		this.map=map;
	}
	public int toInt()
	{
		return map;
	}

}
