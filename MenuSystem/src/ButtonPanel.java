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
	private static final int MAX_COLUMNS = 6;
	
	private List<JButton> buttons;
	private CardPanel cardPanel;
	private CardLayout layout;
	
	public ButtonPanel(String title, List<String> buttonLabels, CardPanel cardPanel)
	{	
		this.cardPanel = cardPanel;
		layout = (CardLayout)cardPanel.getLayout();
		
		setLayout(new BorderLayout());
		setBackground(new Color(209, 208, 199));
		setTitle(title);

		
		if (buttonLabels != null)
		{
			buttons = createButtons(buttonLabels);
			addButtons();
		}
		
	}
	
	private void setTitle(String title)
	{
		JLabel titleLabel = new JLabel("<html><h1>"+title+"</h1></html>");
		add(titleLabel, BorderLayout.NORTH);
		titleLabel.setBorder(new EmptyBorder(15, 10, 0, 0));
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
			
			if (col >= MAX_COLUMNS)
			{
				col = 0;
				row++;
			}
		}
	
		add(panel);
	}
	
	public void buttonPressed(String text)
	{
		layout.show(cardPanel, text);
	}
}
