import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Create a calculator for investment
public class Investment {

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
        //futureValue = investmentAmount * (1 + monthlyInterestRate) ^ (years * 12)
        double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate),  years * 12);
        return futureValue;
    }
}
