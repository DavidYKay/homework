package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.util.*;
public class Transition3 extends DKTransition {
	public void go(LEDDisplayView view, LEDDisplayView.LED[][] leds) {
		Debug.println("Transition3.go()");

        view.clearLEDs();
        LinkedList<Drawable> bitmaps = getWordDrawableList();
        int wordLength = getWordLength(bitmaps);
        /** Measures the length of the word in pixels */

        Drawable blitter = new Drawable(
            new boolean[leds.length][leds[0].length]
        );
        //Offset to center bitmap in frame
        int offset = (leds[0].length - wordLength) / 2;
        blitter.incrementOffset(offset, 0);

        int numInversions = 9;
        LinkedList<Drawable> alterEgo = getWordDrawableList(
            invertCase(getData())
        );

        Drawable[] rouletteDrawables = getRouletteDrawables(leds);

        dropletBlank(leds, true);
        dropletDraw(
            leds,
            rouletteDrawables[0].getBitmap(),
            false
        );
        try {
            for (int i = 0; i <= numInversions; i++) {
                //Thread.sleep(1000);
                //view.clearLEDs();
                for (Drawable blittable : rouletteDrawables) {
                    blittable.blitToBoard(leds);
                    Thread.sleep(100);
                }
            }

        } catch (Exception ex) {
        }

        for (int i = 0; i <= numInversions; i++) {
            try {
                for (Drawable blittable : alterEgo) {
                    blitter.blitBitmap(blittable.getBitmap());
                }
                blitter.blitToBoard(leds);
                blitter.incrementOffset(-getWordLength(alterEgo), 0);

                blitter.clearBitmap();
                Thread.sleep(100);

                for (Drawable blittable : bitmaps) {
                    blitter.blitBitmap(blittable.getBitmap());
                }
                blitter.blitToBoard(leds);
                Thread.sleep(100);
                blitter.incrementOffset(-wordLength, 0);
                blitter.clearBitmap();
            } catch (Exception ex) {
            }
        }

        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
        }
        dropletBlank(leds, false);
    }

    private void dropletDraw(LEDDisplayView.LED[][] leds, boolean[][] bitmap, boolean red) {
        ArrayList<LEDDisplayView.LED> aList = new ArrayList<LEDDisplayView.LED>();
        for (int i = 0; i < leds.length; i++) {
            for (int j = 0; j < leds[i].length; j++) {
                
                if (bitmap[i][j]) {
                    
                } else {
                    aList.add(leds[i][j]);
                }
            }
        }
        Collections.shuffle(aList);

        while (!aList.isEmpty()) {
            LEDDisplayView.LED led = aList.remove(0);
            led.setState(red);
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
            }
        }
    }

    private void dropletBlank(LEDDisplayView.LED[][] leds, boolean red) {
        //Generate
        //There are 80 x 10 total squares
        ArrayList<LEDDisplayView.LED> aList = new ArrayList<LEDDisplayView.LED>();
        for (int i = 0; i < leds.length; i++) {
            for (int j = 0; j < leds[i].length; j++) {
                aList.add(leds[i][j]);
            }
        }
        Collections.shuffle(aList);
        while (!aList.isEmpty()) {
            LEDDisplayView.LED led = aList.remove(0);
            led.setState(red);
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
            }
        }
    }

    private Drawable[] getRouletteDrawables(LEDDisplayView.LED[][] leds) {
        String[] strings = getRouletteStrings(getData());
        Drawable[] drawables = new Drawable[strings.length];

        for (int i = 0; i < strings.length; i++) {
            System.out.println("String: " + strings[i]);
            LinkedList<Drawable> bitmaps = getWordDrawableList(
                strings[i]
            );
            int wordLength = getWordLength(bitmaps);
            Drawable blitter = new Drawable(
                new boolean[leds.length][leds[0].length]
            );
            int offset = (leds[0].length - wordLength) / 2;
            blitter.incrementOffset(offset, 0);
            for (Drawable blittable : bitmaps) {
                blitter.blitBitmap(blittable.getBitmap());
            }
            drawables[i] = blitter;
        }
        return drawables;
    }

    private String invertCase(String string) {
        StringBuilder sb = new StringBuilder();

        for (char character : string.toCharArray()) {
            if (Character.isLowerCase(character)) {
                character = Character.toUpperCase(
                    character
                );
            } else {
                character = Character.toLowerCase(
                    character
                );
            }
            sb.append(character);
        }
        return sb.toString();
    }

    private String[] getRouletteStrings(String string) {
        String[] array = new String[string.length()];

        //Generate a list of strings, each with different a different letter capitalized
        for (int i = 0; i < string.length(); i++) {
            char[] characters = string.toCharArray();
            for (int j = 0; j < string.length(); j++) {
                if (i == j) {
                    characters[j] = Character.toUpperCase(
                        characters[j]
                    );
                } else {
                    characters[j] = Character.toLowerCase(
                        characters[j]
                    );
                }
            }
            array[i] = new String(characters);
        }
        return array;
    }
}
