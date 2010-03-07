package edu.mccc.cos210.leddisplay.transition;

import java.util.*;

public class Letter {
    private static final int HEIGHT = 10;
    //private BitSet[] bitmap;
    private boolean[][] bitmap;

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
        }
    }
    public boolean[][] getBitmap() {
        return bitmap;
    }
}
