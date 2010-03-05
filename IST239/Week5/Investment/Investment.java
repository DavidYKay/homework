//Create a calculator for investment
public class Investment {
    
    public double calculateInvestment( double investmentAmount, double monthlyInterestRate, int years) {
        //futureValue = investmentAmount * (1 + monthlyInterestRate) ^ (years * 12)
        double futureValue = investmentAmount * Math.pow((1 + monthlyInterestRate),  years * 12);
        return futureValue;
    }
    
    /**
     * Exactly the same as above, except with respect to years, not months
     */
    public double calculateLoan( double loanAmount, double annualInterestRate, int years) {
        double totalPayment = loanAmount * Math.pow((1 + annualInterestRate),  years);
        return totalPayment;
    }

}
