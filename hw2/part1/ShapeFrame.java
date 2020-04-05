import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

/**
   A Frame with buttons to select the current drawing shape.
*/
public class ShapeFrame extends JFrame
{
   /**
      Constructs the frame, adds the drawing panel and 
      three basic buttons.
   */
   public ShapeFrame()
   {
      Container contentPane = getContentPane();
      shapePanel = new ShapePanel();
      contentPane.add(shapePanel, BorderLayout.CENTER);
      buttonPanel = Box.createVerticalBox();
      contentPane.add(buttonPanel, BorderLayout.WEST);
   }

   /**
      Adds a shape button to the button panel.
      @param aShape the shape that appears on the button
      face and in the drawing panel.
   */
   public void addShape(final Shape aShape)
   {
      System.out.println("Adding shape.");
      System.out.println("Shape class = " + aShape.getClass());
      System.out.println("Path iterator class = " + aShape.getPathIterator(null).getClass());     

      JButton button = new JButton(new ShapeIcon(aShape, 
         BUTTON_WIDTH, BUTTON_HEIGHT));

      button.addActionListener(new 
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               shapePanel.setShape(aShape);
            }
         });

      buttonPanel.add(button);
   }   

   private ShapePanel shapePanel;
   private Box buttonPanel;
   private int BUTTON_WIDTH = 50;
   private int BUTTON_HEIGHT = 20;
}