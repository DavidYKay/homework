import java.awt.Dimension;
import javax.swing.JFrame;

public class FontDriver
{
	public static void main(String[] args)
	{
		JFrame theFrame = new JFrame("FontMetrics                E. Henry Beitz");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FontPanel fontpanel = new FontPanel();
		fontpanel.setPreferredSize(new Dimension(880, 340));
		theFrame.getContentPane().add(fontpanel);
		theFrame.setLocation(80, 100);
		theFrame.pack();
		theFrame.setVisible(true);
	}
}