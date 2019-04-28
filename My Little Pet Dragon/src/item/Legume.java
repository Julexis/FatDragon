package item;

public class Legume extends Food{
private vegieType type;

public vegieType getType() {
	return type;
}

public void setType(vegieType type) {
	this.type = type;
}

}

enum vegieType
{
	applePie,
	gingerale,
	hotdog,
	orange
}