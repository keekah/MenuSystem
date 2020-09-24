import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ButtonPanel extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	private List<JButton> buttons;
	private CardPanel cardPanel;
	private CardLayout layout;
	
	public ButtonPanel(String title, List<String> buttonLabels, CardPanel cardPanel)
	{	
//		setLayout(new GridLayout(2, 1));
		
		this.cardPanel = cardPanel;
		layout = (CardLayout)cardPanel.getLayout();
		
		setLayout(new BorderLayout());
		setBackground(new Color(209, 208, 199));
		
//		char character = '\u2Ee5';
//		JLabel titleLabel = new JLabel("" + character);
		JLabel titleLabel = new JLabel("<html><h1>"+title+"</h1></html>");
//		add(titleLabel);
		add(titleLabel, BorderLayout.NORTH);
		titleLabel.setBorder(new EmptyBorder(15, 10, 0, 0));
		
		if (buttonLabels != null)
		{
			buttons = createButtons(buttonLabels);
			addButtons();
		}
		
	}
	
	public CardPanel getCardPanel()
	{
		return cardPanel;
	}
	
	public CardLayout getCardLayout()
	{
		return layout;
	}
	
	private List<JButton> createButtons(List<String> labels)
	{
		List<JButton> buttons = new ArrayList<JButton>();
	
		for (String s : labels)
		{
			JButton b = new JButton(s);
			b.setPreferredSize(new Dimension(150, 125));
			b.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						buttonPressed(e.getActionCommand());
						System.out.println(e.getActionCommand());
					}
				});
			buttons.add(b);
		}
		
		return buttons;
	}		
	
	private void addButtons()
	{
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(new Color(209, 208, 199));
		
		int row = 0;
		int col = 0;
		for (JButton b : buttons)
		{
			panel.add(b, new GBC(col++, row).setAnchor(GBC.WEST).setInsets(2));
			
			if (col > (buttons.size()/2))
			{
				row++;
				col = 0;
			}
		}
	
		add(panel);
	}
	
	public void buttonPressed(String text)
	{
		layout.show(cardPanel, text);
	}
}
