import java.awt.Color;
import javax.swing.UIManager;

public class MainApp {
	public static void Callme(){

		UIManager.put("nimbusBase", new Color(25, 100, 255));
		UIManager.put("nimbusBlueGrey", new Color(200, 123, 45));
		UIManager.put("control", new Color(167, 232, 244));
		new MainFrame();
	}
}
