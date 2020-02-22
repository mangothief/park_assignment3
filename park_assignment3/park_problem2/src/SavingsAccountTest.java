public class  SavingsAccountTest
{
	public static void main(String[] args)
	{	
		// Instantiates two SavingsAccount objects called saver1 and saver2.
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		
		// Sets the interest rate to 4%.
		SavingsAccount.modifyInterestRate(0.04);
		
		// Prints out a message.
		System.out.println("Saver1's balance the next 12 months and 4% intererst");
		
		// Calculates the balance for saver1 for 12 months and prints.
		for(int i = 0; i < 12; i++)
		{
			saver1.calculateMonthlyInterest();
			System.out.printf("%.2f \n", saver1.getSavingsBalance());
		}
		
		// Prints out a message.
		System.out.println("\nSaver2's balance the next 12 months at 4% interest");
		
		// Calculates the balance for saver2 for 12 month and prints.
		for(int i = 0; i < 12; i++)
		{
			saver2.calculateMonthlyInterest();
			System.out.printf("%.2f \n", saver2.getSavingsBalance());
		}
		
		// Sets the interest rate to 5%.
		SavingsAccount.modifyInterestRate(0.05);
		
		// Calculates the savings balance for the 13th month with the 5% interest.
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		// Prints out a message.
		System.out.println("\nFirst and Second account balance for the 13th month at 5% interest");
		
		// Prints out the  Savings balance for the 13th month.
		System.out.printf("Saver1: %.2f \n", saver1.getSavingsBalance());
		System.out.printf("Saver2: %.2f \n", saver2.getSavingsBalance());
	}
}