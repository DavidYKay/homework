package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import edu.mccc.cos210.leddisplay.LEDDisplayView.LED;
import com.cbthinkx.util.Debug;

import java.util.*;
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

    public void blitBitmap(boolean[][] bitmap) {
        //assume user wants typewriter style
        blitBitmap(bitmap, false);
    }
    public void blitBitmap(boolean[][] bitmap, boolean scrollBack) {
        blitBitmap(
            bitmap,
            0,
            bitmap.length - 1,
            0,
            bitmap[0].length - 1,
            scrollBack
        );

        /*
        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < bitmap[i].length; j++) {
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
                        bitmap[i][j]
                    );
                }
            }
        }
        if (!scrollBack) {
            incrementOffset(bitmap.length, 0);
        }
        */
    }
    public void blitBitmap(boolean[][] bitmap, int xStart, int xEnd, int yStart, int yEnd, boolean scrollBack) {
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
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
                        bitmap[i][j]
                    );
                }
            }
        }
        if (!scrollBack) {
            incrementOffset(bitmap.length, 0);
        }
    }

    public void incrementOffset(int x, int y) {
        xOffset += x;
        yOffset += y;
    }
}
