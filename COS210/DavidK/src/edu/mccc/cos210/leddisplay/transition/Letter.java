package edu.mccc.cos210.leddisplay.transition;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import javax.imageio.ImageIO;

import java.awt.Graphics.*;
import java.awt.geom.*;
import java.awt.font.*;

public class Letter {
    private static final int HEIGHT = 10;
    private boolean[][] bitmap;

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

    public Letter(char letter) {
        this.bitmap = getBitmapFromFont(letter);
    }
    /*
    public Letter(char letter) {
        switch (letter) {
            case 'i':
                bitmap = new boolean[1][HEIGHT];
                for (int i = 0; i < bitmap.length; i++) {
                    for (int j = 0; j < HEIGHT; j++) {
                        switch (j) {
                            case 0:
                            case 1:
                            case 3:
                                break;
                            default:
                                bitmap[i][j] = true;
                        }
                    }
                }
                break;

            case 'A':
                bitmap = new boolean[8][HEIGHT];
                for (int i = 0; i < bitmap.length; i++) {

                    switch (i) {
                        case 0: 
                        case 7: 
                            for (int j = 8; j < 10; j++) {
                                bitmap[i][j] = true;

                                if (bitmap[i][j]) {
                                    System.out.print(1);
                                } else {
                                    System.out.print(0);
                                }
                            }
                            break;
                        case 1: 
                        case 6: 
                            for (int j = 5; j < 8; j++) {
                                bitmap[i][j] = true;

                                if (bitmap[i][j]) {
                                    System.out.print(1);
                                } else {
                                    System.out.print(0);
                                }
                            }
                            break;
                        case 2: 
                        case 5: 
                            for (int j = 2; j < 6; j++) {
                                bitmap[i][j] = true;

                                if (bitmap[i][j]) {
                                    System.out.print(1);
                                } else {
                                    System.out.print(0);
                                }
                            }
                            break;
                        case 3: 
                        case 4: 
                            bitmap[i][0] = true;
                            bitmap[i][1] = true;
                            bitmap[i][5] = true;
                            break;
                        //default:
                    }
                    System.out.println();
                }
                break;
            default:
                //Look up based on char index
                bitmap = getBitmapFromFont(letter);
        }
    }
    */

    public boolean[][] getBitmap() {
        return bitmap;
    }

    /**
     * Attempt to programatically generate font bitmaps
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
    private boolean[][] getBitmapFromFont(char letter) {
        int offset = 9 * letter;
        
        final int width = 8;
        //boolean[][] bitmap = new boolean[width][HEIGHT];
        //for (int i = 0; i < width; i++) {
        //    int x = offset + i;
        //    for (int j = 0; j < HEIGHT; j++) {
        //        int y = j;
        //        if (font.getRGB(x, y) == -1) { 
        //            bitmap[i][j] = true;
        //        }
        //    }
        //}

        boolean[][] bitmap = new boolean[HEIGHT][width];
        for (int i = 0; i < HEIGHT; i++) {
            //int x = offset + i;
            int y = i;
            for (int j = 0; j < width; j++) {
                //int y = j;
                int x = offset + j;
                if (font.getRGB(x, y) == -1) { 
                    //bitmap[i][j] = true;
                    bitmap[i][j] = true;
                }
            }
        }

        bitmap = trimWhiteSpace(bitmap);
        return bitmap;
    }
    private boolean[][] trimWhiteSpace(boolean[][] bitmap) {
        boolean[][] newBmp;
        int leftBound = 0;
        int rightBound = bitmap[0].length - 1;

    leftSearch:
        for (int i = 0; i < bitmap.length; i++) {
            for (int j = 0; j < bitmap[i].length; j++) {

                int y = i;
                int x = j;
                //once we find a black dot, we know where the starting point is
                //
                if (font.getRGB(x, y) == -1) { 
                    leftBound = x;
                    break leftSearch;
                }
            }
        }

    rightSearch:
        for (int i = bitmap.length - 1; i >= 0; i--) {
            for (int j = bitmap[i].length - 1; j >= 0; j--) {
                //once we find a black dot, we know where the ending point is
                int y = i;
                int x = j;
                if (font.getRGB(x, y) == -1) { 
                    rightBound = x;
                    break rightSearch;
                }
            }
        }
        int width = 1 + rightBound - leftBound;

        System.out.println(
            String.format(
                "rightBound: %d leftBound: %d bitmap.length: %d bitmap[0].length: %d",
                rightBound,
                leftBound,
                bitmap.length,
                bitmap[0].length
            )
        );

        //Create new bitmap for the cropped area
        //newBmp = new boolean[width][bitmap[0].length];
        newBmp = new boolean[bitmap.length][width];
        //blit the contents over
        Blitter blitter = new Blitter(newBmp);
        //blitter.blitBitmap(
        //    bitmap,
        //    leftBound,
        //    rightBound,
        //    0,
        //    bitmap[0].length - 1,
        //    false
        //);
        blitter.blitBitmap(
            bitmap,
            false
        );

        return newBmp;
    }
    public String toString() {
        return Blitter.bitsToString(bitmap);
    }
}
