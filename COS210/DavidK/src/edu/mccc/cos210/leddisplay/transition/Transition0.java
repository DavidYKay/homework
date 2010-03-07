package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.awt.Graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.util.*;

public class Transition0 extends LEDDisplayTransition {
    private static final int FLASH_TIME = 100;
    private static final int NUM_FLASHES = 3;
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition0.go()");

        flashLEDs(view);

        Blitter blitter = new Blitter(leds, 0);
        Letter ltrA = new Letter('A');
        Letter ltrI = new Letter('i');
        boolean[][] aBmp = ltrA.getBitmap();
        boolean[][] iBmp = ltrI.getBitmap();

        blitter.blitBitmap(aBmp);
        blitter.blitBitmap(iBmp);
        blitter.blitBitmap(aBmp);
        blitter.blitBitmap(iBmp);

		try {
            Thread.sleep(1000);
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
    /**
     * Attempt 
     */
    private void getGlyph() {
        AffineTransform at = new AffineTransform();
        Font font = new Font(
            "Dialog",
            Font.PLAIN,
            10
        );
        FontRenderContext frc = new FontRenderContext(
            at,
            false,
            false
        );

        //String input = "Hello World";
        //String input = "ABC";
        String input = "A";
        GlyphVector gv = font.createGlyphVector(
            frc,
            input
        );
        for (int i = 0; i < input.length(); i++) {
            Shape s = gv.getGlyphOutline(i);
            //Iterator iter = s.getPathIterator(at);
            PathIterator iter = s.getPathIterator(at);

            while ( !iter.isDone() ){
                iter.next();
                //Pairs of coordinates
                //double[] coords = new double[10];
                double[] coords = new double[4];
                int code = iter.currentSegment(coords);

                for (int j = 0; j < coords.length - 1; j += 2) {
                    System.out.println( 
                        coords[j] + ", " + coords[j+1] 
                    );
                }
            }

        }


    }
}
