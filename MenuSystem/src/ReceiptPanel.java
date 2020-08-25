import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ReceiptPanel extends JPanel
{
	public ReceiptPanel()
	{
		setLayout(new BorderLayout());
		setBackground(new Color(214, 171, 247));
		
		JLabel label = new JLabel("<html><h2>Items:</h2></html>");
		label.setBorder(new EmptyBorder(0, 8, 0, 0));
//		label.setPreferredSize(new Dimension(125, 125));
		add(label, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton sendButton = new JButton("Send");
		JButton payButton = new JButton("Pay");
//		payButton.setPreferredSize(new Dimension(125, 75));
		buttonPanel.add(sendButton);
		buttonPanel.add(payButton);
		buttonPanel.setBackground(new Color(214, 171, 247));
		add(buttonPanel, BorderLayout.SOUTH);
	}
}
