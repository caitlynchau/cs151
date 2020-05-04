package part2;

public abstract class Pizza {

	public void makeFromScratch() {
		makeCrust();
		addToppings();
		preheatOven();
		cook();
	}
	
	public abstract void makeCrust();
	public abstract void addToppings();
	public abstract void preheatOven();
	public abstract void cook();
}
