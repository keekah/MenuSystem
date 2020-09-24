import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SideButtonPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private CardPanel cardPanel;
	private CardLayout layout;
	private List<JButton> buttons;
	private List<Category> mainCategories;
	
	public SideButtonPanel(CardPanel cardPanel)
	{
		setLayout(new GridBagLayout());
		setBackground(new Color(171, 240, 247));
		
		this.cardPanel = cardPanel;
		this.mainCategories = cardPanel.getMainCategories();
		
		layout = (CardLayout)cardPanel.getLayout();
		
		buttons = createButtons();

		placeLogoImage();
		
		for (int i = 0; i < buttons.size(); i++)
			add(buttons.get(i), new GBC(0, i+1).setInsets(1, 5, 1, 5));
	}


	
	private List<JButton> createButtons()
	{
		List<JButton> buttons = new ArrayList<JButton>();
		
		for (Category c : mainCategories)
		{
			JButton b = new JButton(c.getName());
			b.setPreferredSize(new Dimension(125, 100));
			b.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						buttonPressed(e.getActionCommand());
					}
				});
			buttons.add(b);
		}
		
		return buttons;
			
	}
	
	private void placeLogoImage()
	{
		BufferedImage logo = null;
		try
		{
			logo = ImageIO.read(new File("images/jakes.jpg"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(logo));
		picLabel.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					super.mouseClicked(e);
					logoClicked();
				}
			});
		
		add(picLabel, new GBC(0,0).setInsets(1, 5, 1, 5));
	}
	
	private void logoClicked()
	{
		layout.first(cardPanel);
	}
	
	private void buttonPressed(String text)
	{
		layout.show(cardPanel, text);
	}
}
