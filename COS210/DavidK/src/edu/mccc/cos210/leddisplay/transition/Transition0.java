package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.awt.Graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.util.*;

public class Transition0 extends DKTransition {
    private static final int FLASH_TIME = 100;
    private static final int NUM_FLASHES = 3;
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition0.go()");

        flashLEDs(view);

        LinkedList<Drawable> bitmaps = getWordDrawableList();
        int wordLength = getWordLength(bitmaps);
        /** Measures the length of the word in pixels */
        //Offset to center bitmap in frame
        int offset = (leds[0].length - wordLength) / 2;

        Drawable blitter = new Drawable(
            new boolean[leds.length][leds[0].length]
        );
        blitter.incrementOffset(offset, 0);

        for (Drawable blittable : bitmaps) {
            blitter.blitBitmap(blittable.getBitmap());
        }
        blitter.blitToBoard(leds);

		try {
            Thread.sleep(3000);
		} catch (Exception ex) {
		}
        flashLEDs(view);
        System.out.println("One write completed");
	}
    private void flashLEDs(LEDDisplayView view) {
		try {
            for (int i = 0; i < NUM_FLASHES; i++) {
                view.setLEDs();
                Thread.sleep(FLASH_TIME);
                view.clearLEDs();
                Thread.sleep(FLASH_TIME);
            }
		} catch (Exception ex) {
		}
    }
}
