package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.util.*;
/**
 * Horizontal scroll, entering from right, leaving through the left.
 */
public class Transition2 extends LEDDisplayTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition2.go()");

        view.clearLEDs();

        String toWrite = getData();
        LinkedList<boolean[][]> bitmaps = new LinkedList<boolean[][]>();
        /** Measures the length of the word in pixels */
        int wordLength = 0;
        for (char character : toWrite.toCharArray()) {
            Drawable letter = Letter.makeLetterWithChar(character);
            boolean[][] bmp = letter.getDrawable();
            bitmaps.add(bmp);
            wordLength += bmp[0].length;
        }
        System.out.println("Characters in list: " + bitmaps.size());

        Drawable blitter = new Drawable(
            new boolean[leds.length][leds[0].length], 
            0
        );
        //Loop, sliding text
        for (int i = 0; i <= leds[0].length; i++) {
            for (boolean[][] bmp : bitmaps) {
                blitter.blitBitmap(bmp, false);
            }
            //Increment by one, but roll back to where the word began
            blitter.incrementOffset(1 - wordLength, 0);
            blitter.blitToBoard(leds);
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
            blitter.clearDrawable();
        }

        //Freeze image in center
		try {
            Thread.sleep(3000);
		} catch (Exception ex) {
		}
	}
}
