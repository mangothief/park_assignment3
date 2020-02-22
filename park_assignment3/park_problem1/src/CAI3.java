import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3
{	// Variable declarations
	private static int correctAnswer;
	private static int numberOfCorrectAnswers = 0;
	

	public static void main (String args[])
	{	
		quiz();
	}
	// Logic location which calls upon other methods.
	public static void quiz()
	{	
		askQuestion();
		displayCompletionMessage();
		resetCorrectAnswerNumber();
		tryAgain();
	}
	// Prompts the user for an answer.
	public static void askQuestion()
	{
		// Loops 10 times
		for(int i = 0; i < 10; i++)
		{
			SecureRandom rand = new SecureRandom();
			int rand1 = rand.nextInt(10);
			int rand2 = rand.nextInt(10);
			setAnswer(rand1, rand2);
			System.out.println("How much is " + rand1 + " x " + rand2 + "?");
			isAnswerCorrect(readResponse());
		}
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
			if (choice == getAnswer())
			{
				displayCorrectResponse();
				setPercentage();
			}
			else
			{
				displayIncorrectResponse();
			}
	}
	// Displays a random correct message using switch statement.
	public static void displayCorrectResponse()
	{	
		SecureRandom correctDisplayChoice= new SecureRandom();
		int woohoo = correctDisplayChoice.nextInt(5-1) + 1;

		switch(woohoo)
		{
			case 1: System.out.println("Very good!\n");
					break;
			case 2: System.out.println("Excellent!\n");
					break;
			case 3: System.out.println("Nice work!\n");
					break;
			case 4:	System.out.println("Keep up the good work!\n");
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
			case 1: System.out.println("No. Please try again.\n");
					break;
			case 2: System.out.println("Wrong. Try once more.\n");
					break;
			case 3: System.out.println("Don't give up!\n");
					break;
			case 4:	System.out.println("No. Keep trying.\n");
					break;
		}
	}
	// Sets the number of correct answer.
	public static void setPercentage()
	{
		numberOfCorrectAnswers += 1;
	}
	// Returns the number of correct answers.
	public static int getPercentage()
	{
		return numberOfCorrectAnswers * 10;
	}
	
	// Displays message base upon percentage correct.
	public static void displayCompletionMessage()
	{
		System.out.println("You got " + getPercentage() + "%!!");

		if(getPercentage() >= 75)
		{
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else
		{
			System.out.println("Please ask your teacher for extra help.");
		}
	}
	// Prompts user if they would like to repeat the program.
	public static void tryAgain()
	{
		System.out.println("If you would like to try again press [1], if not, press [2]");
		repeatQuiz(readResponse());
	}
	// Repeats quiz or terminates.
	public static void repeatQuiz(int number)
	{
		if(number == 1)
		{	
			quiz();
		}
		else if (number == 2)
		{
			System.exit(0);
		}
	}
	// Resets the number of correct answers to 0. 
	public static void resetCorrectAnswerNumber()
	{
		numberOfCorrectAnswers = 0;
	}

}