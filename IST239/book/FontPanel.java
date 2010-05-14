import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FontPanel extends JPanel
{
	int LPAD = 20;

	public void paint (Graphics g)
	{
		String message1 = "MiylfajAnhsgcH";
		String message2 = "AnhgjfMiyljfsa";

		String fontname = "Times New Roman";
		
		Font font = new Font(fontname, Font.BOLD, 96);

		g.setFont(font);

		FontMetrics metrics = g.getFontMetrics();
		int fontHeight = metrics.getHeight();
		System.out.println("Height " + fontHeight + " (black vertical line)");
		int fontMaxAscent = metrics.getMaxAscent();
		System.out.println("Max Ascent " + fontMaxAscent);
		int fontAscent = metrics.getAscent();
		System.out.println("Ascent " + fontAscent + " (blue vertical line)");
		int fontMaxDescent = metrics.getMaxDescent ();
		System.out.println("Max Descent " + fontMaxDescent);
		int fontDescent = metrics.getDescent();
		System.out.println("Descent " + fontDescent + " (red vertical line)");
		int fontLeading = metrics.getLeading();
		System.out.println("Leading " + fontLeading);
		int messWidth = metrics.stringWidth (message1);
		System.out.println("Descent + Ascent + Leading is "
			+ (fontDescent + fontAscent + fontLeading));
		System.out.println("Vertical baseline pitch is "
			+ (fontHeight - fontDescent));

		int startX = (getSize().width / 2) - (messWidth/2);
		int startY = (getSize().height / 2)/* + (fontAscent + fontDescent / 2)*/;

		g.setColor (Color.green); // the y-axis center of the box
		g.drawLine (0, startY, 70, startY);

		g.setColor (Color.red); // the descent
		g.drawLine (50, startY, 50, startY + fontDescent);

		g.setColor (Color.blue); // the ascent
		g.drawLine (50, startY, 50, startY - fontAscent);

		g.setColor (Color.black); // the height
		g.drawLine (60, startY + fontDescent, 60, startY - fontAscent - fontLeading);

		g.setColor (Color.green); // font baseline
		g.drawLine (startX - LPAD, startY,
			startX + messWidth + LPAD, startY);
		g.drawLine (startX, startY + LPAD * 5,
			startX, startY - fontMaxAscent - LPAD * 4);

		g.setColor (Color.green); // font baseline for previous line
		g.drawLine (startX - LPAD, startY - fontMaxAscent - fontLeading,
			startX + messWidth + LPAD, startY - fontMaxAscent - fontLeading);

		g.setColor (Color.green); // font baseline for next line
		g.drawLine (startX - LPAD, startY + fontMaxAscent + fontLeading,
			startX + messWidth + LPAD, startY + fontMaxAscent + fontLeading);

		g.setColor (Color.blue); // fontAscent (excludes leading)
		g.drawLine (startX - LPAD, startY - fontMaxAscent,
			startX + messWidth + LPAD, startY - fontMaxAscent);

		g.setColor (Color.red); // fontDescent
		g.drawLine (startX - LPAD, startY + fontMaxDescent,
			startX + messWidth + LPAD, startY + fontMaxDescent);
		g.drawLine (startX - LPAD, startY - fontMaxAscent + fontMaxDescent + fontLeading,
			startX + messWidth + LPAD, startY - fontMaxAscent + fontMaxDescent + fontLeading);

		g.setColor (Color.black);
		g.drawString (message1, startX, startY);
		g.drawString (message2, startX, startY + fontMaxAscent + fontLeading);
		g.drawString (message2, startX, startY - fontMaxAscent - fontLeading);
	}
}
