package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import edu.mccc.cos210.leddisplay.LEDDisplayView.LED;
import com.cbthinkx.util.Debug;

import java.util.*;

//import java.awt.Graphics.*;
//import java.awt.*;
//import java.awt.geom.*;
//import java.awt.font.*;

public class Blitter {
    /** Horizontal offset, 0-based */
    private int xOffset;
    private int yOffset;
    private LED[][] leds;

    //TODO Add vertical/horiz offset?

    public Blitter(LED[][] leds) {
        this(leds, 0);
    }
    public Blitter(LED[][] leds, int xOffset) {
        this.leds = leds;
        this.xOffset = xOffset;
    }

    public void blitBitmap(BitSet[] bitmap) {
        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < bitmap[i].length(); j++) {
                //LED - row, column
                //bitmap - column, row

                int y = j + yOffset;
                int x = i + xOffset;
                //Ensure that X and Y are legal points
                if (x >= 0 && y >= 0 &&
                    x < leds[i].length && 
                    (y < leds.length)
                ) {
                    leds[y][x].setState(
                        bitmap[i].get(j)
                    );
                }
            }
        }
        incrementOffset(bitmap.length, 0);
    }
    public void incrementOffset(int x, int y) {
        xOffset += x;
        yOffset += y;
    }
}
