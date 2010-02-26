import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A simple view/controller to allow the user to interact with the "business 
 * logic" in Investment
 */
public class InvestmentPanel extends JPanel {

    private final Investment investment;

    private JTextField investmentAmount;
    private JTextField monthlyInterestRate;
    private JTextField futureValue;

    public InvestmentPanel(Investment investment) {
        this.investment          = investment;
        this.investmentAmount    = new JTextField("Investment Amount");
        this.monthlyInterestRate = new JTextField("Monthly Interest Rate");
        this.futureValue         = new JTextField("Future Value");
        
        //Temp
        final int years = 10;

        add(investmentAmount);
        add(monthlyInterestRate);
        JButton compute = new JButton("Compute");
        compute.addActionListener( new ActionListener() {
            public void actionPerformed (ActionEvent e) {

                futureValue.setText(
                    String.valueOf(
                        InvestmentPanel.this.investment.calculateInvestment(
                            //String.valueOf(investmentAmount.getText()),
                            //String.valueOf(monthlyInterestRate.getText()),
                            Double.parseDouble(investmentAmount.getText()),
                            Double.parseDouble(monthlyInterestRate.getText()),
                            years
                        )
                    )
                );
                //futureValue.setText("Yahoo!");
            }
        });
        add(compute);
        add(futureValue);
    }

}
