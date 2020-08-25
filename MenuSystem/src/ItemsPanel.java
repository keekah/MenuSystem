import java.awt.CardLayout;
import java.util.List;

public class ItemsPanel extends ButtonPanel
{
	private static final long serialVersionUID = 1L;

	public ItemsPanel(String title, List<String> buttonLabels, CardPanel cardPanel)
	{
		super(title, buttonLabels, cardPanel);
		// TODO Auto-generated constructor stub
	}
	
	public void buttonPressed(String text)
	{
		CardLayout layout = getCardLayout();
		
		layout.show(getCardPanel(), text);
	}

}
