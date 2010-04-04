import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SplitPanel extends JPanel {
	public SplitPanel() {		
        setLayout(
            new BorderLayout()
        );

        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(
            new GridLayout(2, 2)
        );

        final JTextField nameField = new JTextField();
        final JTextField numField = new JTextField();
        //final JLabel result = new JLabel();

        cellPanel.add(
            new JLabel("File name:")
        );
        cellPanel.add(nameField);
        cellPanel.add(
            new JLabel("Number of pieces:")
        );
        cellPanel.add(numField);

        JButton button = new JButton("Split Files");
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    System.out.println("ActionPerformed");
                    splitFile(
                        nameField.getText().trim(),
                        Integer.parseInt(numField.getText())
                    );
                }
            }
        );
        add(
            cellPanel,
            BorderLayout.CENTER
        );
        add(
            button,
            BorderLayout.SOUTH
        );
        //add(
        //    result,
        //    BorderLayout.SOUTH
        //);
	}
    private void splitFile(String fileName, int numPieces) {
        System.out.println("Filename: " + fileName);
        System.out.println("numPieces: " + numPieces);
        //Create a file handle
        File file = new File(fileName);
        //Check file length
        long bytes = file.length();
        long perChunk = bytes / numPieces;
        //excess from rounding error
        long excess = bytes % perChunk; 

        //Read in the file
        //Split the file
        //Output the pieces
        try {
            FileInputStream  fIn  = new FileInputStream(file);
            //for each chunk
            for (int i = 1; i <= numPieces; i++) {
                FileOutputStream fOut = new FileOutputStream(
                    new File(
                        fileName + "." + i
                    )
                );
                long endPos = i * perChunk;
                for (long outPos = 0; outPos < endPos; outPos++) {
                    //write up until the end position
                    fOut.write(
                        fIn.read()
                    );
                }
                if (i == numPieces) {
                    //on the last chunk, write in the excess
                    //for (long outPos = 0; outPos < excess; outPos++) {
                    //    fOut.write(
                    //        fIn.read()
                    //    );
                    //}
                    int nextUnsignedByte = 0;
                    while ((nextUnsignedByte = fIn.read()) != -1) {
                        System.out.println("Read " + nextUnsignedByte);
                        fOut.write(nextUnsignedByte);
                    }
                }
                fOut.close();
            }
            fIn.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

    //private void writeFile(File file, int pieceNum, long begin, long end) {
    private void writeFile(File file) {
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            for (int i = 0; i < 300; i++) {
                fOut.write(i);
            }
            fOut.close();
        } catch (IOException ioe) {
        }
    }

    private void readFile(File file) {
        try {
            FileInputStream fin = new FileInputStream(file);
            int nextUnsignedByte = 0;
            while ((nextUnsignedByte = fin.read()) != -1) {
                System.out.println("Read " + nextUnsignedByte);
            }
            fin.close();
        } catch (IOException ioe) {
        }
    }
}
