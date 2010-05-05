package edu.mccc.ist239.piechart;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The actual client GUI. A ChatClient object is used to send/received messages from the server.
 */
public class PieChartTest extends JPanel {
    private JTextArea nameField;
    private JTextArea chatText;
    private JTextField inputField;

    public PieChartTest() {
        //GUI
        setLayout(new BorderLayout());
        chatText = new JTextArea();
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            }
        );

        add(
            chatText,
            BorderLayout.NORTH
        );

        JPanel chartPanel = new JPanel();
        chartPanel.setLayout(
            new GridLayout(
                //2, 1
                1, 2
            )
        );

        //Create model
        DataModel model = new DataModel();
        PieChart pieChart = new PieChart();
        chartPanel.add(
            pieChart
        );

        BarChart barChart = new BarChart(model);
        chartPanel.add(
            barChart
        );
        add(
            chartPanel,
            BorderLayout.CENTER
        );

        setPreferredSize(
            new Dimension(
                500,
                500
            )
        );
    }

    public static void main(String[] sa) {
		JFrame frame = new JFrame();
		frame.setTitle("Chat Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.add(
            new PieChartTest()
        );
		frame.pack();
		frame.setVisible(true);
    }

    private void sendMessage() {
        System.out.println("SendMessage");
    }
}
