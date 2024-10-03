/* SELF ASSESSMENT
   1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code? 
       Mark out of 10: 10
       Comment: I used comprehensible variables and constants within my code. The constants decreased the amount of numbers in the code,
       making it more meaningful.
   2. Did I format the variable and CONSTANT names appropriately (in lowerCamelCase and UPPERCASE)?
       Mark out of 5: 5
       Comment: I used lowercamelCase for variables and UPPERCASE for my constants.
   3. Did I generate the computer's choice in each game correctly using a Random number generator?
       Mark out of 10: 10
       Comment: I correctly used a random number generator in each game to generate the computer's random choice.
   4. Did I input the user's choice in each game correctly?
       Mark out of 10: 10
       Comment: I inputed the user's choice in each game correctly every game.
   5. Did I correctly compare the choices and update the score appropriately?
       Mark out of 20: 20
       Comment: I compared the choices and updated the scores correctly, awarding 1 point for a win and 0 points for a loss or draw.
   6. Did I inform the user of who won each game (and why) correctly?
       Mark out of 10: 10
       Comment: I informed the user of the outcome of each game correctly, giving a reason every time.
   7. Did I use an appropriate for loop to allow the player to play 5 games? There should be only one loop.
       Mark out of 20: 20
       Comment: I used 1 for loop to allow the player to play NUMBER_OF_ATTEMPTS games, where NUMBER_OF_ATTEMPTS is a constant defined
       at the top of the program. (NUMBER_OF_ATTEMPTS = 5).
   8. Did I output the final scores correctly after the 5 games were played?
       Mark out of 10: 10
       Comment: I correctly output the final scores after the 5 games were played.
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: I provided a mark and comment for each criterion.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class RockPaperScissors {
	
	public static final int ROCK = 1;
	public static final int PAPER = 2;
	public static final int SCISSORS = 3;
	public static final int NUMBER_OF_ATTEMPTS = 5;
	public static final String WIN_MESSAGE = "You have won because I chose ";
	public static final String LOSE_MESSAGE = "You have lost becuase I chose ";
	public static final String TIE_MESSAGE = "We have tied because I, too, have chosen ";
	
	public static void main(String[] args) {
	
	int userGuess = 0;
	int score = 0;
	int computerScore = 0;
	Random numberGenerator = new Random();
	
	for (int attempt = 1; attempt <= NUMBER_OF_ATTEMPTS; attempt++)
	{
		String input = JOptionPane.showInputDialog("This is attempt " + attempt + " out of " + NUMBER_OF_ATTEMPTS + "." +
				"\n" + "(Enter 1 for Rock, 2 for Paper or 3 for Scissors).");
		
		Scanner guessScanner = new Scanner(input);
		if (guessScanner.hasNextInt())
		{
			userGuess = guessScanner.nextInt();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid input. Please enter either 1, 2 or 3.");
			attempt = attempt - 1;
			continue;
		}
		
		int computerGuess = numberGenerator.nextInt(3) + 1;
		String computerChoice = "";
		
		if (computerGuess == ROCK)
		{
			computerChoice = "Rock";
		}
		else if (computerGuess == PAPER)
		{
			computerChoice = "Paper";
		}
		else if (computerGuess == SCISSORS)
		{
			computerChoice = "Scissors";
		}
		
		if (computerGuess == ROCK)
		{
			if (userGuess == SCISSORS)
			{
				JOptionPane.showMessageDialog(null, LOSE_MESSAGE + computerChoice + ".");
				computerScore = computerScore + 1;
			}
			else if (userGuess == PAPER)
			{
				JOptionPane.showMessageDialog(null, WIN_MESSAGE + computerChoice + ".");
				score = score + 1;
			}
			else if (userGuess == ROCK)
			{
				JOptionPane.showMessageDialog(null, TIE_MESSAGE + computerChoice + ".");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter either 1, 2 or 3.");
				attempt = attempt - 1;
				continue;
			}
		
		}
		
		if (computerGuess == PAPER)
		{
			if (userGuess == ROCK)
			{
				JOptionPane.showMessageDialog(null, LOSE_MESSAGE + computerChoice + ".");
				computerScore = computerScore + 1;
			}
			else if (userGuess == SCISSORS)
			{
				JOptionPane.showMessageDialog(null, WIN_MESSAGE + computerChoice + ".");
				score = score + 1;
			}
			else if (userGuess == PAPER)
			{
				JOptionPane.showMessageDialog(null, TIE_MESSAGE + computerChoice + ".");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter either 1, 2 or 3.");
				attempt = attempt - 1;
				continue;
			}
		}
		
		if (computerGuess == SCISSORS)
		{
			if (userGuess == PAPER)
			{
				JOptionPane.showMessageDialog(null, LOSE_MESSAGE + computerChoice + ".");
				computerScore = computerScore + 1;
			}
			else if (userGuess == ROCK)
			{
				JOptionPane.showMessageDialog(null, WIN_MESSAGE + computerChoice + ".");
				score = score + 1;
			}
			else if (userGuess == SCISSORS)
			{
				JOptionPane.showMessageDialog(null, TIE_MESSAGE + computerChoice + ".");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter either 1, 2 or 3.");
				attempt = attempt - 1;
				continue;
			}
		}
		guessScanner.close();
	}
	
	if (score > computerScore)
	{
		JOptionPane.showMessageDialog(null, "Your final score is " + score + " and my final score is " + computerScore + ", therefore you win!");
	}
	else if (score < computerScore)
	{
		JOptionPane.showMessageDialog(null, "Your final score is " + score + " and my final score is " + computerScore + ", therefore you lose.");
	}
	else
	{
		JOptionPane.showMessageDialog(null, "Your final score is " + score + " and my final score is " + computerScore + ", therefore we draw.");
	}
	
	}

}
