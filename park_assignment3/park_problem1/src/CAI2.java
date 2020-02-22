import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2
{	// Variable declarations
	private static int correctAnswer;

	public static void main (String args[])
	{	
		quiz();
	}
	// Logic location which calls upon other methods.
	public static void quiz()
	{
		askQuestion();
		isAnswerCorrect(readResponse());
	}
	// Prompts the user for an answer.
	public static void askQuestion()
	{
		SecureRandom rand = new SecureRandom();
		int rand1 = rand.nextInt(10);
		int rand2 = rand.nextInt(10);
		setAnswer(rand1, rand2);
		System.out.println("How much is " + rand1 + " x " + rand2 + "?");
	}
	// Reads in the response fron the user.
	public static int readResponse()
	{
		Scanner userAnswer = new Scanner(System.in);
		int response = userAnswer.nextInt();
		return response;
	}
	// Sets the correct answer.
	public static void setAnswer(int rand1, int rand2)
	{	
		correctAnswer = rand1 * rand2;
	}
	// Calls the correct answer.
	public static int getAnswer()
	{
		return correctAnswer;
	}
	// Checks if the answer is correct then displays the corresponding response
	// until the correct answer is inputted.
	public static void isAnswerCorrect(int choice)
	{
		do 
		{	
			if (choice == getAnswer())
			{
				displayCorrectResponse();
				System.exit(0);
			}
			else
			{
				displayIncorrectResponse();
				isAnswerCorrect(readResponse());
			}

		}while(choice != getAnswer());
	}
	// Displays a random correct message using switch statement.
	public static void displayCorrectResponse()
	{	
		SecureRandom correctDisplayChoice= new SecureRandom();
		int woohoo = correctDisplayChoice.nextInt(5-1) + 1;

		switch(woohoo)
		{
			case 1: System.out.println("Very good!");
					break;
			case 2: System.out.println("Excellent!");
					break;
			case 3: System.out.println("Nice work!");
					break;
			case 4:	System.out.println("Keep up the good work!");
					break;
		}
	}
	// Displays a random incorrect message using switch statement.
	public static void displayIncorrectResponse()
	{
		SecureRandom incorrectDisplayChoice= new SecureRandom();
		int booo = incorrectDisplayChoice.nextInt(5-1) + 1;

		switch(booo)
		{
			case 1: System.out.println("No. Please try again.");
					break;
			case 2: System.out.println("Wrong. Try once more.");
					break;
			case 3: System.out.println("Don't give up!");
					break;
			case 4:	System.out.println("No. Keep trying.");
					break;
		}
	}
}