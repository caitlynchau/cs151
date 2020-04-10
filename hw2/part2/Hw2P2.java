import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Hw2P2 {

	private JFrame textFrame;
	private JFrame graphFrame;
	
	private DataModel dataModel;
	private TextView textView;
	private GraphView graphView;
	
	private File file;

	public Hw2P2(String fileName) {
		
		// Create new file
		fileName = "src\\" + fileName + ".txt";
		file = new File(fileName);

		if (!file.exists()) { // if file does not exist, create a new one
			System.out.println("file does not exist");
			return;
		}
		
		// Scan file's data and create new model
		dataModel = new DataModel(initializeModelData());

		// Create new text view and add it to the model
		textView = new TextView(dataModel);
		initializeTextFrame();

		// Create new graph view and add it to the model
		graphView = new GraphView(dataModel);
		initializeGraphFrame();

		// attach observers to model
		dataModel.addObserver(textView);
		dataModel.addObserver(graphView);

	}

	/**
	 * Scan the File's data line by line
	 * @return arraylist with scanned integers
	 */
	public ArrayList<Integer> initializeModelData() {
		ArrayList<Integer> data = new ArrayList<Integer>();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				int num = Integer.parseInt(line); // parse line for integer
				data.add(num);
			}
			scanner.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * Create a frame and add the TextFrame to it
	 */
	public void initializeTextFrame() {
		textFrame = new JFrame();
		textFrame.add(textView);

		// textFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textFrame.pack();
		textFrame.setVisible(true);
		textFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) { // click to close window
				writeToFile(); // save model's data to File
				graphFrame.dispose(); // close the other window
				System.exit(0); // end the application
			}
		});
	}

	/**
	 * Create a frame and add the GraphFrame to it
	 */
	public void initializeGraphFrame() {
		graphFrame = new JFrame();
		graphFrame.setSize(300, 300);
		graphFrame.add(graphView);

		graphFrame.setVisible(true);
		graphFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) { // click to close the window
				writeToFile(); // save model's data to File
				textFrame.dispose(); // close the other window
				System.exit(0); // end the application
			}
		});
	}

	/**
	 * Write each integer in the model to the file
	 */
	public void writeToFile() {
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);

			for (int i = 0; i < dataModel.getData().size(); i++) {
				out.println(dataModel.getData().get(i));
			}

			out.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String fileName = args[0];
		Hw2P2 hw = new Hw2P2(fileName);
		//Hw2P2 hw = new Hw2P2("src\\p2\\data.txt");

	}
}
