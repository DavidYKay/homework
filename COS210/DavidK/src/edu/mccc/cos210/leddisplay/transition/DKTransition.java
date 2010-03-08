package edu.mccc.cos210.leddisplay.transition;
import edu.mccc.cos210.leddisplay.*;
import com.cbthinkx.util.Debug;

import java.util.*;

public abstract class DKTransition extends LEDDisplayTransition {
    
    protected LinkedList<Drawable> getWordDrawableList() {
        LinkedList<Drawable> bitmaps = new LinkedList<Drawable>();
        /** Measures the length of the word in pixels */
        int wordLength = 0;
        for (char character : getData().toCharArray()) {
            Drawable letter = Letter.makeLetterWithChar(character);
            bitmaps.add(letter);
        }
        return bitmaps;
    }
    protected int getWordLength(LinkedList<Drawable> bitmaps) {
        int wordLength = 0;
        for(Drawable bitmap : bitmaps) {
            wordLength += bitmap.getWidth();
        }
        return wordLength;
    }
}
