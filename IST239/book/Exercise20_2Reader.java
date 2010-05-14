import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class Exercise20_2Reader extends JFrame implements ActionListener {
  private JTextArea jta = new JTextArea(40, 80);
  private JTextField jtfFilename = new JTextField(10);
  private JTextField jtfEncoding = new JTextField(4);
  private JButton jbtViewFile = new JButton("View File");

  public Exercise20_2Reader() {
    JPanel panel = new JPanel();
    panel.add(new JLabel("Enter a file:"));
    panel.add(jtfFilename);
    panel.add(new JLabel("Enter the encoding scheme:"));
    panel.add(jtfEncoding);
    panel.add(jbtViewFile);

    jta.setEditable(false);
    jta.setFont(new Font("Monospaced", Font.PLAIN, 16));
    getContentPane().add(panel, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

    jbtViewFile.addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    String filename = jtfFilename.getText().trim();
    String encoding = jtfEncoding.getText().trim();

    try {
      Scanner in = new Scanner(new File(filename), encoding);
      while (in.hasNext()) {
        jta.append(in.nextLine() + "\n");
      }
    }
    catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void main(String args[]) {
      JFrame frame = new Exercise20_2Reader();
      frame.setTitle("Exercise20_2Reader");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(400, 300);
      frame.setVisible(true);
  }
}

