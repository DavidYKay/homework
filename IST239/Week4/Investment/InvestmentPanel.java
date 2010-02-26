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
    private JTextField futureValue;
    private JTextField years;

    public InvestmentPanel(Investment investment) {
        this.investment          = investment;

        //LinkedList<JComponent> components = new LinkedList<JComponent>();
        //components.add( new JTextField("Investment Amount"));
        //components.add( new JTextField("Monthly Interest Rate"));
        //components.add( new JTextField("Future Value"));
        //components.add( new JTextField("Years"));

        this.investmentAmount    = new JTextField("Investment Amount");
        this.monthlyInterestRate = new JTextField("Monthly Interest Rate");
        this.futureValue         = new JTextField("Future Value");
        this.years               = new JTextField("Years");


        //setLayout(new FlowLayout());
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

        add(inputPanel);

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
                            Integer.parseInt(years.getText())
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
