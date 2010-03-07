package edu.mccc.cos210.leddisplay.transition;

import java.util.*;

public class Letter {
    private static final int HEIGHT = 10;
    //private BitSet[] bitmap;
    private boolean[][] bitmap;

    public Letter(char letter) {
        switch (letter) {
            case 'i':
                //bitmap = new BitSet[1];
                bitmap = new boolean[1][10];
                for (int i = 0; i < bitmap.length; i++) {
                    //bitmap[0] = new BitSet(HEIGHT);
                        for (int j = 0; j < HEIGHT; j++) {
                            switch (j) {
                                case 0:
                                case 1:
                                case 3:
                                    break;
                                default:
                                    //bitmap[i].set(j);
                                    bitmap[i][j] = true;
                            }
                        }
                }
                break;

                /*
            case 'A':
                bitmap = new BitSet[8];
                for (int i = 0; i < bitmap.length; i++) {
                    bitmap[i] = new BitSet(HEIGHT);

                    switch (i) {
                        case 0: 
                        case 7: 
                            for (int j = 8; j < 10; j++) {
                                bitmap[i].set(j);

                                if (bitmap[i].get(j)) {
                                    System.out.print(1);
                                } else {
                                    System.out.print(0);
                                }
                            }
                            break;
                        case 1: 
                        case 6: 
                            for (int j = 5; j < 8; j++) {
                                bitmap[i].set(j);

                                if (bitmap[i].get(j)) {
                                    System.out.print(1);
                                } else {
                                    System.out.print(0);
                                }
                            }
                            break;
                        case 2: 
                        case 5: 
                            for (int j = 2; j < 6; j++) {
                                bitmap[i].set(j);

                                if (bitmap[i].get(j)) {
                                    System.out.print(1);
                                } else {
                                    System.out.print(0);
                                }
                            }
                            break;
                        case 3: 
                        case 4: 
                            bitmap[i].set(0);
                            bitmap[i].set(1);
                            bitmap[i].set(5);
                            break;
                        //default:
                    }
                    System.out.println();
                }
                break;
                            */
        }
    }

    //public BitSet[] getBitmap() {
    public boolean[][] getBitmap() {
        return bitmap;
    }
}
