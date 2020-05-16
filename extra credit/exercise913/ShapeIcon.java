package exercise913;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
   An icon that contains a Moveable shape.
*/
public class ShapeIcon implements Icon
{
   private int width;
   private int height;
   private MoveableShape shape;
	   
   public ShapeIcon(MoveableShape shape,
      int width, int height)
   {
      this.shape = shape;
      this.width = width;
      this.height = height;
   }
   
   public int getIconWidth()
   {
      return width;
   }

   public int getIconHeight()
   {
      return height;
   }

   public void paintIcon(Component c, Graphics g, int x, int y)
   {
      Graphics2D g2 = (Graphics2D) g;
      shape.draw(g2);
   }

}