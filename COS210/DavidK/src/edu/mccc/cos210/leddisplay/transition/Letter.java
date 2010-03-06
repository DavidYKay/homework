package edu.mccc.cos210.leddisplay.transition;

import java.util.*;

public class Letter {
    private static final int HEIGHT = 10;
    private BitSet[] bitmap;

    public Letter(char letter) {
        switch (letter) {
            case 'A':
            case 'a':
                bitmap = new BitSet[10];
                for (int i = 0; i < bitmap.length; i++) {
                    bitmap[i] = new BitSet(HEIGHT);
                    //bitmap[i].xor(bitmap[i]);

                    //for (int j = 0; j < bitmap[i].length(); j++) {
                    for (int j = 0; j < HEIGHT; j++) {
                        bitmap[i].set(j);
                        
                        if (bitmap[i].get(j)) {
                            System.out.print(1);
                        } else {
                            System.out.print(0);
                        }
                        //System.out.print(bitmap[i].get(j));
                        //System.out.print(true);
                    }
                    System.out.println();
                }
                break;
        }
    }

    public BitSet[] getBitmap() {
        return bitmap;
    }
}
