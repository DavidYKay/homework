package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import edu.mccc.cos210.leddisplay.LEDDisplayView.LED;
import com.cbthinkx.util.Debug;

import java.util.*;
public class Blitter {
    /** Horizontal offset, 0-based */
    private int xOffset;
    private int yOffset;
    //private LED[][] leds;
    private boolean[][] leds;

    public Blitter(boolean[][] leds) {
        this(leds, 0);
    }
    public Blitter(boolean[][] leds, int xOffset) {
        this.leds = leds;
        this.xOffset = xOffset;
    }

    public void clearBitmap() {
        //leds = new boolean[leds.length][leds[0].length];
        for (int i = 0; i < leds.length; i++) {
            for (int j = 0; j < leds[i].length; j++) {
                leds[i][j] = false;
            }
        }
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
    }
    public void blitBitmap(boolean[][] bitmap, int xStart, int xEnd, int yStart, int yEnd, boolean scrollBack) {
        
        System.out.println(
            String.format(
                "SIZES: leds(%d,%d) bitmap(%d,%d)",
                leds.length,
                leds[0].length,
                bitmap.length,
                bitmap[0].length
            )
        );
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                //int y = j + yOffset;
                //int x = i + xOffset;
                //int x = i + xOffset;
                //int y = j + yOffset;

                int x = i + xOffset;
                int y = j + yOffset;

                //Ensure that X and Y are legal points
                if (x >= 0 && y >= 0 &&
                    x < leds[i].length && 
                    (y < leds.length)
                ) {
                    //System.out.println(
                    //    String.format(
                    //        "leds(%d,%d) bitmap(%d,%d)",
                    //        x,
                    //        y,
                    //        i,
                    //        j
                    //    )
                    //);
                    leds[y][x] = bitmap[i][j];
                    //leds[x][y] = bitmap[i][j];
                    //leds[i][j] = bitmap[i][j];
                }
            }
        }
        if (!scrollBack) {
            incrementOffset(bitmap.length, 0);
        }
    }

    /**
     * Blit own content to a lightboard
     */
    public void blitToBoard(LED[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                //LED - row, column
                //bitmap - column, row
                int y = i;
                int x = j;
                //Ensure that X and Y are legal points
                if (x >= 0 && y >= 0 &&
                    x < leds[i].length && 
                    (y < leds.length)
                ) {
                    if (board[y][x].isOn() != leds[i][j]) {
                        board[y][x].setState(
                            leds[i][j]
                        );
                    }
                }
            }
        }
        //System.out.println(this);
        //if (!scrollBack) {
        //    incrementOffset(bitmap.length, 0);
        //}
    }

    public void incrementOffset(int x, int y) {
        xOffset += x;
        yOffset += y;
    }
    public String toString() {
        return Blitter.bitsToString(leds);
    }
    public static String bitsToString(boolean[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]) {
                    sb.append(
                        '1'
                    );
                } else {
                    sb.append(
                        '0'
                    );
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
