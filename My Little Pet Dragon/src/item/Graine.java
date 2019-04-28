package item;

public class Graine extends Item{
private grainType type;



public grainType getType() {
	return type;
}

public void setType(grainType type) {
	this.type = type;
}

}

enum grainType
{
	yellow,//apple pie
	blue,//gingerale
	red,//hotdog
	green//orange
}