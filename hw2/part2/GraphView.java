import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class GraphView extends JPanel implements Observer {
	
	private DataModel model;
	private static final int HEIGHT = 20;
	private ArrayList<Rectangle2D> rectangles;
	
	public GraphView(DataModel aModel) {
		model = aModel;
		
		rectangles = new ArrayList<Rectangle2D>();
		
		// Create Rectangle2D objects and add them to arraylist
		for (int i = 0; i < model.getData().size(); i++) {
			double x = 0;
			double y = HEIGHT * i;
			double width = model.getData().get(i);
			Rectangle2D rect = new Rectangle2D.Double(x, y, width, HEIGHT);
			rectangles.add(rect);
		}
		
		// Attach a mouse listener to this JPanel
		this.addMouseListener(new MouseAdapter() {
			
			// Override mousePressed 
			public void mousePressed(MouseEvent event) {
				int x = event.getX(); // this is the new width
				int y = event.getY(); 
				
				int index = y / HEIGHT;
				if (index < model.getData().size()) {
					model.set(index, x);
				}
			}
			
			
		});
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		// paint all rectangles on this JPanel
		for (Rectangle2D rect : rectangles) {
			g2.draw(rect);
		}
	}

	@Override
	/**
	 * Model has been updated so update the view
	 */
	public void update(Observable o, Object arg) {
		ArrayList<Integer>model = (ArrayList<Integer>)arg;
		
		// Iterate through model and redraw every single rectangle
		for (int i = 0; i < model.size(); i++) { 
			double x = 0;
			double y = HEIGHT * i;
			double width = model.get(i);
			rectangles.set(i, new Rectangle2D.Double(x, y, width, HEIGHT));
		}
		this.repaint();
	}

}
