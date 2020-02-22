import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1
{	// Variable declarations
	private static int correctAnswer;	

	public static void main (String args[])
	{	
		quiz();
	}
	// Logic Location which calls upon other methods.
	public static void quiz()
	{
		askQuestion();
		isAnswerCorrect(readResponse());
	}
	// Prompts the user for an answer
	public static void askQuestion()
	{
		SecureRandom rand = new SecureRandom();
		int rand1 = rand.nextInt(10);
		int rand2 = rand.nextInt(10);
		setAnswer(rand1, rand2);
		System.out.println("How much is " + rand1 + " x " + rand2 + "?");
	}
	// Reads in the response from the user.
	public static int readResponse()
	{
		Scanner userAnswer = new Scanner(System.in);
		int response = userAnswer.nextInt();
		return response;
	}
	// Sets the correct answer
	public static void setAnswer(int rand1, int rand2)
	{	
		correctAnswer = rand1 * rand2;
	}
	// Calls the correct answer
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
	// Displays the correct response.
	public static void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
	// Displays the incorrect response.
	public static void displayIncorrectResponse()
	{
		System.out.println("No. Please try again");
	}

}