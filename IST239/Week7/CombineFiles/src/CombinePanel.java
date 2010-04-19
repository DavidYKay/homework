import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class CombinePanel extends JPanel {
	public CombinePanel() {		
        setLayout(
            new BorderLayout()
        );

        JPanel cellPanel = new JPanel();
        cellPanel.setLayout(
            new GridLayout(2, 2)
        );

        final JTextField nameField = new JTextField();
        final JTextField numField = new JTextField();

        cellPanel.add(
            new JLabel("File name:")
        );
        cellPanel.add(nameField);
        cellPanel.add(
            new JLabel("Number of pieces:")
        );
        cellPanel.add(numField);

        JButton button = new JButton("Combine Files");
        button.addActionListener(
            new ActionListener() {
                public void actionPerformed (ActionEvent e) {
                    System.out.println("ActionPerformed");
                    combineFile(
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
	}

    /**
     * Combine file chunks into one binary
     */
    private void combineFile(String fileName, int numPieces) {
        //Create a file handle
        File file = new File(fileName);
        System.out.println("Filename: " + fileName);
        System.out.println("numPieces: " + numPieces);
        
        //Read in the file
        //Split the file
        //Output the pieces
        try {
            FileOutputStream fOut = new FileOutputStream(file);
            //for each chunk
            for (int i = 1; i <= numPieces; i++) {
                FileInputStream fIn = new FileInputStream(
                    new File(
                        fileName + "." + i
                    )
                );
                int nextUnsignedByte = 0;
                while ((nextUnsignedByte = fIn.read()) != -1) {
                    System.out.println("Read " + nextUnsignedByte);
                    fOut.write(nextUnsignedByte);
                }
                fIn.close();
            }
            fOut.close();
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }

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
