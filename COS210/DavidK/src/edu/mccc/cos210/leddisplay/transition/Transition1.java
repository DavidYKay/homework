package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.util.*;
/**
 * Vertical scroll, entering from top, leaving through the bottom.
 */
public class Transition1 extends DKTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition1.go()");

        view.clearLEDs();

        String toWrite = getData();
        LinkedList<Drawable> bitmaps = getWordDrawableList();
        /** Measures the length of the word in pixels */
        int wordLength = getWordLength(bitmaps);

        Drawable blitter = new Drawable(
            new boolean[leds.length][leds[0].length]
        );
        int offset = (leds[0].length - wordLength) / 2;
        blitter.incrementOffset(offset, -leds.length);
        //Loop, sliding text
        for (int i = 0; i <= leds.length; i++) {
            for (Drawable drawable : bitmaps) {
                blitter.blitBitmap(drawable.getBitmap(), false);
            }
            //Increment by one, but roll back to where the word began
            blitter.incrementOffset(- wordLength, 1);
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

        //Loop, sliding text
        for (int i = 0; i <= leds.length; i++) {
            for (Drawable drawable : bitmaps) {
                blitter.blitBitmap(drawable.getBitmap(), false);
            }
            //Increment by one, but roll back to where the word began
            blitter.incrementOffset(- wordLength, 1);
            blitter.blitToBoard(leds);
            try {
                Thread.sleep(50);
            } catch (Exception ex) {
            }
            blitter.clearDrawable();
        }

		try {
            Thread.sleep(1000);
		} catch (Exception ex) {
		}
	}
}
