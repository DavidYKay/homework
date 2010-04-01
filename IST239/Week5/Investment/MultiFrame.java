import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Create a calculator for investment
public class MultiFrame extends JApplet {

    public void init() {
        this.setLayout(new FlowLayout());

        JButton investButton = new JButton("Investment");
        investButton.addActionListener( 
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JFrame newFrame = new JFrame();
                    newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    newFrame.setLocationRelativeTo(MultiFrame.this);
                    newFrame.add(new InvestmentPanel(new Investment()));
                    newFrame.pack();
                    newFrame.setVisible(true);
                }
            }
        );
        add(investButton);

        JButton loanButton = new JButton("Loan");
        loanButton.addActionListener( 
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JFrame newFrame = new JFrame();
                    newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    newFrame.setLocationRelativeTo(MultiFrame.this);
                    newFrame.add(new LoanPanel(
                            new Investment()
                            ));
                    newFrame.pack();
                    newFrame.setVisible(true);
                }
            }
        );
        add(loanButton);
    }
}
