import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class FileViewerNew extends JFrame implements ActionListener {
  // Button to view a file
  private JButton jbtView = new JButton("View");

  // Text field to the receive file name
  private JTextField jtfFilename = new JTextField(12);

  // Text area to display the file
  private JTextArea jtaFile = new JTextArea();

  public FileViewerNew() {
    // Panel p to hold a label, a text field, and a button
    Panel p = new Panel();
    p.setLayout(new BorderLayout());
    p.add(new Label("Filename"), BorderLayout.WEST);
    p.add(jtfFilename, BorderLayout.CENTER);
    p.add(jbtView, BorderLayout.EAST);

    // Add jtaFile to a scroll pane
    JScrollPane jsp = new JScrollPane(jtaFile);

    // Add jsp and p to the frame
    getContentPane().add(jsp, BorderLayout.CENTER);
    getContentPane().add(p, BorderLayout.SOUTH);

    // Register listener
    jbtView.addActionListener(this);
  }

  /** Handle the View button */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == jbtView)
      showFile();
  }

  /** Display the file in the text area */
  private void showFile() {
    // Get file name from the text field
    String filename = jtfFilename.getText().trim();

    try {
      // Create a buffered stream
      Scanner input = new Scanner(new File(filename));

      // Read a line and append the line to the text area
      while (input.hasNext()) {
        jtaFile.append(input.nextLine() + '\n');
      }
    }
    catch (FileNotFoundException ex) {
      System.out.println("File not found: " + filename);
    }
  }

  public static void main(String[] args) {
    FileViewerNew frame = new FileViewerNew();
    frame.setTitle("FileViewerNew");
    frame.setSize(400, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
