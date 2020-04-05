import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
   A panel that holds positioned shapes.
*/
public class ShapePanel extends JPanel
{
   /**
      Constructs a shape panel.
   */
   public ShapePanel()
   {
      shapes = new ArrayList();

      addMouseListener(new
         MouseAdapter()
         {
            public void mousePressed(MouseEvent event)
            {
               if (currentShape == null) return;
               shapes.add(new PositionedShape(event.getPoint(),
                  currentShape));
               repaint();
            }
         });
   }

   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      for (int i = 0; i < shapes.size(); i++)
      {
         PositionedShape s = (PositionedShape)shapes.get(i);
         s.draw(g2);         
      }
   } 

   /**
      Set the current drawing shape.
      @param aShape the shape to add when the mouse is clicked.
   */
   public void setShape(Shape aShape)
   {
      currentShape = aShape;
   }

   private Shape currentShape;
   private ArrayList shapes;
}