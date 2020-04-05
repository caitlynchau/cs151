import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   This is the program that the grader will run. 
   Add the three fancy shapes that are required by the assignment
*/
public class Hw2P1
{
   public static void main(String[] args)
   {
      ShapeFrame frame = new ShapeFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(WIDTH, HEIGHT);
      frame.setTitle("Hw2");

      frame.addShape(new Rectangle2D.Double(0, 0, 20, 30));
      frame.addShape(new Ellipse2D.Double(0, 0, 30, 30));
      frame.addShape(new Line2D.Double(0, 0, 30, 30));
      frame.addShape(carShape());
      frame.addShape(houseShape());
      frame.addShape(helloShape());

      frame.show();
   }

   /**
      Constructs a car shape.
      @return the shape
   */
   private static Shape carShape()
   {
      CompositeShape shape = new CompositeShape();

      final double WIDTH = 60;
      Rectangle2D.Double body
         = new Rectangle2D.Double(0, WIDTH / 6, 
            WIDTH, WIDTH / 6);
      Ellipse2D.Double frontTire
         = new Ellipse2D.Double(WIDTH / 6, WIDTH / 3, 
            WIDTH / 6, WIDTH / 6);
      Ellipse2D.Double rearTire
         = new Ellipse2D.Double(WIDTH * 2 / 3, WIDTH / 3,
            WIDTH / 6, WIDTH / 6);

      // the bottom of the front windshield
      Point2D.Double r1
         = new Point2D.Double(WIDTH / 6, WIDTH / 6);
      // the front of the roof
      Point2D.Double r2
         = new Point2D.Double(WIDTH / 3, 0);
      // the rear of the roof
      Point2D.Double r3
         = new Point2D.Double(WIDTH * 2 / 3, 0);
      // the bottom of the rear windshield
      Point2D.Double r4
         = new Point2D.Double(WIDTH * 5 / 6, WIDTH / 6);

      Line2D.Double frontWindshield
         = new Line2D.Double(r1, r2);
      Line2D.Double roofTop
         = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield
         = new Line2D.Double(r3, r4);
      

      shape.add(body);
      shape.add(frontTire);
      shape.add(rearTire);
      shape.add(frontWindshield);
      shape.add(roofTop);
      shape.add(rearWindshield);

      return shape;
   }

   /**
      Constructs a house shape.
      @return the shape
   */
   private static Shape houseShape()
   {
      CompositeShape shape = new CompositeShape();

      final double WIDTH = 50;
      final double HEIGHT = 80;

      Rectangle2D.Double front = new Rectangle2D.Double(0, HEIGHT - WIDTH, WIDTH, WIDTH);
      Rectangle2D.Double door = new Rectangle2D.Double(WIDTH / 5, HEIGHT - WIDTH / 2, WIDTH / 5, WIDTH / 2);
      Rectangle2D.Double window = new Rectangle2D.Double(WIDTH * 3 / 5, HEIGHT - WIDTH / 2, WIDTH / 5, WIDTH / 5);
      Line2D.Double roofLeft = new Line2D.Double(0, HEIGHT - WIDTH, WIDTH / 2, 0);
      Line2D.Double roofRight = new Line2D.Double(WIDTH, HEIGHT - WIDTH, WIDTH / 2, 0);

      shape.add(front);
      shape.add(door);
      shape.add(window);
      shape.add(roofLeft);
      shape.add(roofRight);

      return shape;
   }

   /**
      Constructs a "Hello" outline shape
      @return the shape
   */
   private static Shape helloShape()
   {
      String message = "Hello";
      FontRenderContext context = new FontRenderContext() {};
      Font f = new Font("SansSerif", Font.BOLD, 24);
      TextLayout layout = new TextLayout(message, f, context);
      AffineTransform transform 
         = AffineTransform.getTranslateInstance(0, 
            layout.getAscent());
      return layout.getOutline(transform);
   }

   public static final int WIDTH = 300;
   public static final int HEIGHT = 300;
}
