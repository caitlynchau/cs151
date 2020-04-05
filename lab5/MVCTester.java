public class MVCTester {
	private Model model;
	private View view;
	private Controller controller;
	
	public MVCTester() {
		model = new Model();
		view = new View();
		controller = new Controller(model, view);

	}
	
	public void run() {
		controller.initController();
	}
	
	public static void main(String[] args) {
		MVCTester tester = new MVCTester();
		tester.run();
	}
}
