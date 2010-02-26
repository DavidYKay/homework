import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Investment {
    //Create a calculator for investment

	public void doit() {
		JFrame frame = new JFrame();
		frame.setTitle("Investment Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        frame.add(new InvestmentPanel(this));
		frame.pack();
		frame.setVisible(true);
    }

	public static void main(String[] args) {
		new Investment().doit();
	}

    public double calculateInvestment( double investmentAmount, double monthlyInterestRate, int years) {
        double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate),  12);
        //futureValue = investmentAmount * (1 + monthlyInterestRate) ^ (years * 12)
        return futureValue;
    }
}
