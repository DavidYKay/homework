package chapter35;

public class Loan {
  private double annualInterestRate;
  private int numOfYears;
  private double loanAmount;
  private java.util.Date loanDate;

  /** Default constructor */
  public Loan() {
    this(7.5, 30, 100000);
  }

  /** Construct a loan with specified annual interest rate,
      number of years and loan amount
    */
  public Loan(double annualInterestRate, int numOfYears,
    double loanAmount) {
    this.annualInterestRate = annualInterestRate;
    this.numOfYears = numOfYears;
    this.loanAmount = loanAmount;
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /** Return numOfYears */
  public int getNumOfYears() {
    return numOfYears;
  }

  /** Set a new numOfYears */
  public void setNumOfYears(int numOfYears) {
    this.numOfYears = numOfYears;
  }

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount */
  public void setLoanAmount(double loanAmount) {
    this.loanAmount = loanAmount;
  }

  /** Find monthly payment */
  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    return loanAmount * monthlyInterestRate / (1 -
      (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
  }

  /** Find total payment */
  public double getTotalPayment() {
    return getMonthlyPayment() * numOfYears * 12;
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }
}
