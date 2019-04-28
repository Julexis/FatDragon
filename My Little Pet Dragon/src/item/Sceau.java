package item;

public class Sceau extends Item{
	private Boolean isFull;
	
	
	public Boolean getIsFull() {
		return isFull;
	}
	
	public void fill() {
		this.isFull = true;
	}
	
	public void empty() {
		this.isFull = false;
	}
	
}
