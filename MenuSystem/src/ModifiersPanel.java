import java.awt.CardLayout;
import java.util.List;

public class ModifiersPanel extends ButtonPanel
{
	private static final long serialVersionUID = 1L;

	public ModifiersPanel(String title, List<String> buttonLabels, CardPanel cardPanel)
	{
		super(title, buttonLabels, cardPanel);
		// TODO Auto-generated constructor stub
	}

	public void buttonPressed(String text)
	{
		CardLayout layout = getCardLayout();
		
		layout.first(getCardPanel());
		
		// TODO add items to receipt panel
	}
}
