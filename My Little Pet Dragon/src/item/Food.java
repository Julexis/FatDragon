package item;

public class Food extends Item{
	private int foodValue;//nombre de point que la nourriture donne au dragon lorsqu'elle est consommé
	
	public int getFoodValue() {
		return foodValue;
	}
	
	public void setFoodValue(int foodValue) {
		this.foodValue = foodValue;
	}
	
}
