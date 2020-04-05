import java.awt.geom.*;
import javax.swing.*;

/**
   A test program for the basic shape program
   (before adding the interesting buttons)
*/
public class BasicShapeFrameTest
{
   public static void main(String[] args)
   {
      ShapeFrame frame = new ShapeFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(WIDTH, HEIGHT);
      frame.setTitle("BasicShapeFrameTest");

      frame.addShape(new Rectangle2D.Double(0, 0, 20, 30));
      frame.addShape(new Ellipse2D.Double(0, 0, 30, 30));
      frame.addShape(new Line2D.Double(0, 0, 30, 30));

      frame.show();
   }

   public static final int WIDTH = 300;
   public static final int HEIGHT = 300;
}