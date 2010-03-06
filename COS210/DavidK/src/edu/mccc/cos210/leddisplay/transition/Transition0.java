package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.awt.Graphics.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import java.util.*;

public class Transition0 extends LEDDisplayTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition0.go()");
        int numFlashes = 3;

        Letter a = new Letter('a');
        BitSet[] bitmap = a.getBitmap();

        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < bitmap[i].length(); j++) {
                //LED - row, column
                //bitmap - column, row
                leds[j][i].setState(
                    bitmap[i].get(j)
                );
            }
        }

        /*
		try {
            view.clearLEDs();
            for (int i = 0; i < numFlashes; i++) {
                view.setLEDs();
                Thread.sleep(100);
                view.clearLEDs();
                Thread.sleep(100);
            }
            //Milliseconds
		} catch (Exception ex) {
		}
        */
        System.out.println("One write completed");
	}

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
