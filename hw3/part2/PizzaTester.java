package part2;

public class PizzaTester {
	
	public static void main(String[] args) {
		ChicagoStyle chicago = new ChicagoStyle();
		CaliforniaStyle cali = new CaliforniaStyle();
		NewYorkStyle ny = new NewYorkStyle();
		
		chicago.makeFromScratch();
		cali.makeFromScratch();
		ny.makeFromScratch();
		
	}
}
