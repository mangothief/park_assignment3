public class SavingsAccount
{	
	// Variable declarations
	private static double annualInterestRate;
	private double savingsBalance;
	
	// Constructor that takes in a double variable
	public SavingsAccount(double savingsBalance)
	{
		this.savingsBalance = savingsBalance;
	}
	
	// Returns savingsbalance.
	public double getSavingsBalance()
	{
		return this.savingsBalance;
	}
	
	// Calculates the intereset rate and adds to savings balance.
	public void calculateMonthlyInterest()
	{
		double interestIncrease = (savingsBalance * annualInterestRate) / 12;
		this.savingsBalance = savingsBalance + interestIncrease;
	}
	
	// Sets the interest rate.
	public static void modifyInterestRate(double newInterestRate)
	{
		annualInterestRate = newInterestRate;
	}
}