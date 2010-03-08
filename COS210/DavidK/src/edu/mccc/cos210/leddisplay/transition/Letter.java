package edu.mccc.cos210.leddisplay.transition;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

import java.awt.Graphics.*;
import java.awt.geom.*;
import java.awt.font.*;

//public class Letter extends Drawable {
public class Letter {
    private static final int HEIGHT = 10;

    private static BufferedImage font;
    static {
        try {
            font = ImageIO.read(
                new FileInputStream(
                    "res/font.bmp"
                )
            );
        } catch (Exception ex) {
            System.err.println(ex.getMessage());      
        }
    }
    //if (font.getRGB(x, y) == -1) { }

    public static Drawable makeLetterWithChar(char letter) {
        boolean[][] bitmap = null;
        switch (letter) {
            case ' ':
                bitmap = new boolean[1][4];
                break;
            default:
                bitmap = getDrawableFromFont(letter);
        }
        return new Drawable(bitmap);
    }

    /**
     * Attempt to programatically generate font bitmaps
     */
    private static void getGlyph() {
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
        String input = "A";
        GlyphVector gv = font.createGlyphVector(
            frc,
            input
        );
        for (int i = 0; i < input.length(); i++) {
            Shape s = gv.getGlyphOutline(i);
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
    //private boolean[][] getDrawableFromFont(char letter) {
    private static boolean[][] getDrawableFromFont(char letter) {
        int offset = 9 * letter;
        
        final int width = 8;

        boolean[][] bitmap = new boolean[HEIGHT][width];
        for (int i = 0; i < HEIGHT; i++) {
            int y = i;
            for (int j = 0; j < width; j++) {
                int x = offset + j;
                if (font.getRGB(x, y) == -1) { 
                    bitmap[i][j] = true;
                }
            }
        }

        bitmap = trimWhiteSpace(bitmap);
        return bitmap;
    }
    private static boolean[][] trimWhiteSpace(boolean[][] bitmap) {
        boolean[][] newBmp;
        int leftBound = 0;
        int rightBound = bitmap[0].length - 1;

    leftSearch:
        for (int j = 0; j < bitmap[0].length; j++) {
            for (int i = 0; i < bitmap.length; i++) {

                int y = i;
                int x = j;
                //once we find a black dot, we know where the starting point is
                //if (font.getRGB(x, y) == -1) { 
                if (bitmap[i][j]) { 
                    leftBound = x;
                    break leftSearch;
                }
            }
        }

    rightSearch:
            for (int j = bitmap[0].length - 1; j >= 0; j--) {
                for (int i = bitmap.length - 1; i >= 0; i--) {
                //once we find a black dot, we know where the ending point is
                int y = i;
                int x = j;
                //if (font.getRGB(x, y) == -1) { 
                if (bitmap[i][j]) { 
                    rightBound = x;
                    break rightSearch;
                }
            }
        }
        int width = 1 + rightBound - leftBound;

        System.out.println(
            String.format(
                "rightBound: %d leftBound: %d bitmap.length: %d bitmap[0].length: %d WIDTH: %d",
                rightBound,
                leftBound,
                bitmap.length,
                bitmap[0].length,
                width
            )
        );

        //Create new bitmap for the cropped area
        newBmp = new boolean[bitmap.length][width];
        //blit the contents over
        Drawable blitter = new Drawable(newBmp);
        blitter.incrementOffset(-leftBound, 0);
        blitter.blitBitmap(
            bitmap,
            leftBound,
            rightBound,
            0,
            bitmap.length - 1,
            false
        );
        return newBmp;
    }
}
