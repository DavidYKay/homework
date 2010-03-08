package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.util.*;
public class Transition1 extends LEDDisplayTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition1.go()");

        view.clearLEDs();

        //String toWrite = "ABC";
        //String toWrite = "A";
        String toWrite = getData();
        LinkedList<boolean[][]> bitmaps = new LinkedList<boolean[][]>();
        /** Measures the length of the word in pixels */
        int wordLength = 0;
        for (char character : toWrite.toCharArray()) {
            Letter letter = new Letter(character);
            boolean[][] bmp = letter.getBitmap();
            bitmaps.add(bmp);
            //wordLength += bmp.length;
            wordLength += bmp[0].length;
        }
        System.out.println("Characters in list: " + bitmaps.size());

        //Blitter blitter = new Blitter(leds, 0);
        Blitter blitter = new Blitter(
            new boolean[leds.length][leds[0].length], 
            0
        );
        //Loop, sliding text
        for (int i = 0; i < leds[0].length; i++) {
            for (boolean[][] bmp : bitmaps) {
                //blitter.blitBitmap(bmp);
                //blitter.blitBitmap(bmp, true);
                blitter.blitBitmap(bmp, false);
            }
            blitter.incrementOffset(1 - wordLength, 0);
            //blitter.incrementOffset(1, 0);
            blitter.blitToBoard(leds);
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
            blitter.clearBitmap();
        }

        //Freeze image in center
		try {
            Thread.sleep(3000);
		} catch (Exception ex) {
		}
	}
}
