package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.util.*;
/**
 * Horizontal scroll, entering from right, leaving through the left.
 */
public class Transition2 extends DKTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition2.go()");

        view.clearLEDs();

        LinkedList<Drawable> bitmaps = getWordDrawableList();
        /** Measures the length of the word in pixels */
        int wordLength = getWordLength(bitmaps);

        Drawable blitter = new Drawable(
            new boolean [leds.length][leds[0].length], 
            0
        );
        //Loop, sliding text
        for (int i = 0; i <= leds[0].length; i++) {
            for (Drawable drawable : bitmaps) {
                blitter.blitBitmap(drawable.getBitmap(), false);
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
