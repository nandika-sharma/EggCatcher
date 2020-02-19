
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RoundButton extends JButton {
  public RoundButton(String label) {
    super(label);

// These statements enlarge the button so that it 
// becomes a circle rather than an oval.
    Dimension size = getPreferredSize();
    size.width = size.height = Math.max(size.width, 
      size.height);
    setPreferredSize(size);

// This call causes the JButton not to paint 
   // the background.
// This allows us to paint a round background.
    setContentAreaFilled(false);
  }

// Paint the round background and label.
  protected void paintComponent(Graphics g) {
    if (getModel().isArmed()) {
// You might want to make the highlight color 
   // a property of the RoundButton class.
      g.setColor(new Color(245,10,98));
    } else {
      g.setColor(getBackground());
    }
   // g.fillOval(0, 0, getSize().width-1, getSize().height-1);
    g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
// This call will paint the label and the 
   // focus rectangle.
    super.paintComponent(g);
  }

// Paint the border of the button using a simple stroke.
  protected void paintBorder(Graphics g) {
    g.setColor(getForeground());
  //  g.drawOval(0, 0, getSize().width-1,  getSize().height-1);
    g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
  }
}