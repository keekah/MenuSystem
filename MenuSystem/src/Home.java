import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;



public class Home extends JFrame
{
	public Home()
	{
		setFrameSize();
		setLayout(new BorderLayout());
		
		
		CardPanel cardPanel = new CardPanel(this);
		
		add(new SideButtonPanel(cardPanel), BorderLayout.WEST);
		add(cardPanel, BorderLayout.CENTER);
		add(new ReceiptPanel(), BorderLayout.EAST);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void setFrameSize()
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		setSize(width/4, height/2);	
		setLocationRelativeTo(null);
	}

}
