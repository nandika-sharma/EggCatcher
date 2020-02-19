import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
public class Imgpanel extends JPanel{

	ImageIcon icon;
	String image;
	int width,height;
	public Imgpanel(String image,int a,int b)
	{
		this.image=image;
		width=a;
		height=b;
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		icon=new ImageIcon(image);
		g.drawImage(icon.getImage(), 0, 0, width ,height , null);
	}
}