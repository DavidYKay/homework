package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.util.*;
public class Transition1 extends LEDDisplayTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition1.go()");

        view.clearLEDs();

        //String toWrite = "A";
        String toWrite = getData();
        LinkedList<boolean[][]> bitmaps = new LinkedList<boolean[][]>();
        /** Measures the length of the word in pixels */
        int wordLength = 0;
        for (char character : toWrite.toCharArray()) {
            Letter letter = new Letter(character);
            boolean[][] bmp = letter.getBitmap();
            bitmaps.add(bmp);
            wordLength += bmp.length;
        }

        Blitter blitter = new Blitter(leds, 0);
        //Loop, sliding text
        for (int i = 0; i < leds[0].length; i++) {
            //int offset = (leds[0].length - wordLength) / 2;
            //int offset = leds[0].length - i;
            blitter.incrementOffset(1, 0);
            for (boolean[][] bmp : bitmaps) {
                blitter.blitBitmap(bmp, true);
            }
            try {
                //Thread.sleep(100);
                Thread.sleep(50);
            } catch (Exception ex) {
            }
        }
        //Freeze image in center
		try {
            Thread.sleep(3000);
		} catch (Exception ex) {
		}

	}
}
