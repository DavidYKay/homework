import java.awt.*;

public enum TrafficColor {
	RED    ( 0, Color.RED    ) ,
	YELLOW ( 1, Color.YELLOW ) ,
	GREEN  ( 2, Color.GREEN  ) ;

	private final int value; 
	private final Color color; 
	TrafficColor(int value, Color color) {
		this.value = value;
		this.color = color;
	}
	public int getValue()   { return value; } 
	public Color getColor() { return color; } 
}
