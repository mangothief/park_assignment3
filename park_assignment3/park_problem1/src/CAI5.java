import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5
{	// Variable declarations
	private static double correctAnswer;
	private static int numberOfCorrectAnswers = 0;
	private final static int diff1 = 10;
	private final static int diff2 = 100;
	private final static int diff3 = 1000;
	private final static int diff4 = 10000;
	private static int firstNumber;
	private static int secondNumber;
	private static String symbol;
	private static double difficultyLevel;
	private static double problemChoice;
	// Main method which calls upon quiz method.
	public static void main (String args[])
	{	
		quiz();
	}
	// Logic location which calls upon other methods.
	public static void quiz()
	{	
		System.out.println("\nThis program will help you get better at math!.....maybe");
		readDifficulty();
		readProblemType();
		askQuestion();
		displayCompletionMessage();
		resetCorrectAnswerNumber();
		tryAgain();
	}
	// Reads in the difficulty level. 
	public static void readDifficulty()
	{
		System.out.println("First, choose the diffculty level from [1] - [4], with [1] being the easiest.");
		difficultyLevel = readResponse();
	}
	// Generates random numbers of various types depending on difficulty.
	public static void generateQuestionArgument(double difficultyLevel)
	{
		SecureRandom rand = new SecureRandom();

		if(difficultyLevel == 1)
		{
			int rand1 = rand.nextInt(diff1);
			int rand2 = rand.nextInt(diff1);
			setFirstRandom(rand1);
			setSecondRandom(rand2);
		}

		else if(difficultyLevel == 2)
		{
			int rand1 = rand.nextInt(diff2);
			int rand2 = rand.nextInt(diff2);
			setFirstRandom(rand1);
			setSecondRandom(rand2);	
		}

		else if(difficultyLevel == 3)
		{
			int rand1 = rand.nextInt(diff3);
			int rand2 = rand.nextInt(diff3);
			setFirstRandom(rand1);
			setSecondRandom(rand2);
		}

		else if(difficultyLevel == 4)
		{
			int rand1 = rand.nextInt(diff4);
			int rand2 = rand.nextInt(diff4);
			setFirstRandom(rand1);
			setSecondRandom(rand2);
		}
	}
	// Prompts and reads what type of questions the user would like to be asked.
	public static void readProblemType()
	{	
		System.out.println("What Type of problems would you like to solve?");
		System.out.println("Press [1] for addition.");
		System.out.println("Press [2] for multiplication.");
		System.out.println("Press [3] for subtraction.");
		System.out.println("Press [4] for division.");
		System.out.println("Press [5] for random mixture of the above.");
	
		problemChoice = readResponse();
		setSymbol(problemChoice);
	}

	public static void whichProblems(double problemChoice)
	{
		if(problemChoice == 1)
		{
			solveAddition(getFirstRandom(), getSecondRandom());
		}
		else if (problemChoice == 2)
		{
			solveMulti(getFirstRandom(), getSecondRandom());
		}
		else if(problemChoice == 3)
		{
			solveDiff(getFirstRandom(), getSecondRandom());
		}
		else if(problemChoice == 4)
		{
			solveQuoRem(getFirstRandom(), getSecondRandom());
		}
		else if(problemChoice == 5)
		{
			solveRandom(getFirstRandom(), getSecondRandom());
		}
	}
	// Prompts the user to answer 10 questions.
	public static void askQuestion()
	{
		for(int i = 0; i < 10; i++)
		{
			generateQuestionArgument(difficultyLevel);
			whichProblems(problemChoice);
			System.out.println("What is " + getFirstRandom() + " " + getSymbol() + " " + getSecondRandom() + "?");
			isAnswerCorrect(readResponse());
		}
	}
	// Checks if the answer is correct.
	public static void isAnswerCorrect(double choice)
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
			case 1: System.out.println("Very good! \n");
					break;
			case 2: System.out.println("Excellent! \n");
					break;
			case 3: System.out.println("Nice work! \n");
					break;
			case 4:	System.out.println("Keep up the good work! \n");
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
			case 1: System.out.println("No. Please try again. \n");
					break;
			case 2: System.out.println("Wrong. Try once more. \n");
					break;
			case 3: System.out.println("Don't give up! \n");
					break;
			case 4:	System.out.println("No. Keep trying. \n");
					break;
		}
	}
	// Determines which symbol is needed depending on the question.
	public static void setSymbol(double typeOfProblem)
	{
		if(typeOfProblem == 1)
		{
			symbol = " + ";
		}
		else if(typeOfProblem == 2)
		{
			symbol = " x ";
		}
		else if(typeOfProblem == 3)
		{
			symbol = " - ";
		}
		else if(typeOfProblem == 4)
		{
			symbol = " / ";
		}
	}
	// Returns the symbol.
	public static String getSymbol()
	{
		return symbol;
	}
	// Reads in the response fron the user.
	public static double readResponse()
	{
		Scanner userAnswer = new Scanner(System.in);
		double response = userAnswer.nextDouble();
		return response;
	}
	// Sets the correct answer and rounds up to the second decimal place.
	public static void setAnswer(double answer)
	{	
		correctAnswer = (double) Math.round(answer * 100) / 100;
	}
	// Calls the correct answer.
	public static double getAnswer()
	{	
		return correctAnswer;
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
	public static void repeatQuiz(double number)
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
	// Sets the first randomly generated number.
	public static void setFirstRandom(int firstRand)
	{
		firstNumber = firstRand;
	}
	// Returns the randomly generated first number.
	public static int getFirstRandom()
	{
		return firstNumber;
	}
	// Sets the second randomly generated number.
	public static void setSecondRandom(int secondRand)
	{
		secondNumber = secondRand;
	}
	// Returns the randomly generated second number
	public static int getSecondRandom()
	{
		return secondNumber;
	}
	
	// Resets the number of correct answers to 0. 
	public static void resetCorrectAnswerNumber()
	{
		numberOfCorrectAnswers = 0;
	}
	// Adds up the 2 random numbers.
	public static void solveAddition(double number1, double number2)
	{
		double sum = number1 + number2;
		setAnswer(sum);
	}
	// Multiplies the 2 random numbers.
	public static void solveMulti(double number1, double number2)
	{
		double product = number1 * number2;
		setAnswer(product);
	}
	// Subtracts the 2 random numbers.
	public static void solveDiff(double number1, double number2)
	{
		double  difference = number1 - number2;
		setAnswer(difference);
	}
	// Divides the 2 random numbers.
	public static void solveQuoRem(double number1, double number2)
	{	
		double quoRem = number1 / number2;
		System.out.println("Please answer to the second decimal place, rounded up.");
		setAnswer(quoRem);
	}
	// Randomly picks which mathematic questions to solve.
	public static void solveRandom(double number1, double number2)
	{
		SecureRandom randomQuestion= new SecureRandom();
		int solveIt = randomQuestion.nextInt(5-1) + 1;

		switch(solveIt)
		{
			case 1: solveAddition(number1, number2);
					setSymbol(1);
					break;
			case 2: solveDiff(number1, number2);
					setSymbol(3);
					break;
			case 3: solveMulti(number1, number2);
					setSymbol(2);
					break;
			case 4:	solveQuoRem(number1, number2);
					setSymbol(4);
					break;
		}
	}
}