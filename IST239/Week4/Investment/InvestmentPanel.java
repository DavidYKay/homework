import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * A simple view/controller to allow the user to interact with the "business 
 * logic" in Investment
 */
public class InvestmentPanel extends JPanel {

    private final Investment investment;

    private JTextField investmentAmount;
    private JTextField monthlyInterestRate;
    private JTextField years;
    private JLabel futureValue;

    public InvestmentPanel(Investment investment) {
        this.investment          = investment;

        this.investmentAmount    = new JTextField("Investment Amount");
        this.monthlyInterestRate = new JTextField("Monthly Interest Rate");
        this.years               = new JTextField("Years");
        this.futureValue         = new JLabel("0");

        setLayout(new BoxLayout(
            this,
            BoxLayout.Y_AXIS
        ));

        JPanel inputPanel = new JPanel();
        //Fields and prompts
        inputPanel.setLayout(
            new GridLayout(4, 2)
        );
        inputPanel.add(new JLabel("Investment Amount"));
        inputPanel.add(investmentAmount);
        inputPanel.add(new JLabel("Monthly Interest Rate"));
        inputPanel.add(monthlyInterestRate);
        inputPanel.add(new JLabel("Years"));
        inputPanel.add(years);
        inputPanel.add(new JLabel("Future Value"));
        inputPanel.add(futureValue);

        inputPanel.setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
        add(inputPanel);

        JButton compute = new JButton("Compute");
        compute.addActionListener( new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                futureValue.setText(
                    String.valueOf(
                        InvestmentPanel.this.investment.calculateInvestment(
                            Double.parseDouble(investmentAmount.getText()),
                            Double.parseDouble(monthlyInterestRate.getText()),
                            Integer.parseInt(years.getText())
                        )
                    )
                );
            }
        });
        JPanel computePanel = new JPanel();
        computePanel.setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
        //setLayout(new FlowLayout());

        computePanel.add(compute);
        add(computePanel);
    }
}
