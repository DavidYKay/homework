import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * A simple view/controller to allow the user to interact with the "business 
 * logic" in Loan
 */
public class LoanPanel extends JPanel {

    private final Investment investment;

    private JTextField annualInterestRate;
    private JTextField years;
    private JTextField loanAmount;
    private JLabel totalPayment;
    private JLabel monthlyPayment;

    public LoanPanel(Investment investment) {
        this.investment          = investment;

        this.loanAmount         = new JTextField();
        this.annualInterestRate = new JTextField();
        this.years              = new JTextField();
        this.totalPayment       = new JLabel("0");
        this.monthlyPayment     = new JLabel("0");

        setLayout(new BoxLayout(
            this,
            BoxLayout.Y_AXIS
        ));

        JPanel inputPanel = new JPanel();
        //Fields and prompts
        inputPanel.setLayout(
            new GridLayout(5, 2)
        );

        inputPanel.add(new JLabel("Annual Interest Rate"));
        inputPanel.add(annualInterestRate);

        inputPanel.add(new JLabel("Years"));
        inputPanel.add(years);

        inputPanel.add(new JLabel("Loan Amount"));
        inputPanel.add(loanAmount);
        
        inputPanel.add(new JLabel("Monthly Payment"));
        inputPanel.add(monthlyPayment);

        inputPanel.add(new JLabel("Total Payment"));
        inputPanel.add(totalPayment);

        inputPanel.setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
        add(inputPanel);

        JButton compute = new JButton("Compute");
        compute.addActionListener( new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                int numYears = Integer.parseInt(years.getText());
                double total = LoanPanel.this.investment.calculateLoan(
                    Double.parseDouble(loanAmount.getText()),
                    Double.parseDouble(annualInterestRate.getText()),
                    numYears
                );
                totalPayment.setText(
                    String.valueOf(
                        total
                    )
                );
                monthlyPayment.setText(
                    String.valueOf(
                        total / (12 * numYears)
                    )
                );
            }
        });
        JPanel computePanel = new JPanel();
        computePanel.setBorder(
            BorderFactory.createLineBorder(Color.BLACK)
        );
        computePanel.add(compute);
        add(computePanel);
    }
}
