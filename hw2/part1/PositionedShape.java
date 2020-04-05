import java.awt.*;
import java.awt.geom.*;

/**
   A shape with a position offset.
*/
public class PositionedShape
{
   /**
      Constructs a PositionedShape.
      @param aPosition the top left position
      @param aShape the shape to be positioned
   */
   public PositionedShape(Point2D aPosition, Shape aShape)
   {
      position = aPosition;
      shape = aShape;
   }

   /**
      Draws the shape at its intended position.
      @param g2 the graphics context
   */
   public void draw(Graphics2D g2)
   {
      AffineTransform oldTransform = g2.getTransform();
      g2.translate(position.getX(), position.getY());
      g2.draw(shape);
      g2.setTransform(oldTransform);
   }

   private Point2D position;
   private Shape shape;
}