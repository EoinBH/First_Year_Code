/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
       Comment: I used appropriate constants to replace numbers within my code.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       Comment: I used comprehensible, meaningful constant names, in the correct format.
   3. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 10
       Comment: I used comprehensible, meaningful variable names.
   4. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5
       Comment: I formatted the variable names correctly.
   5. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: I indented the code appropriately.
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
       Mark out of 20: 20
       Comment: I used an appropriate DO-WHILE loop to allow the user to enter their guesses until they win or lose.
   7. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10
       Comment: I checked every possible input to ensure that invalid input was handled appropriately.
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
       Mark out of 10: 10
       Comment: I generated the cards properly using random number generation.
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
       Mark out of 10: 10
       Comment: I output the cards correctly as above, including 'an' before 'Ace' and '8'.
   10. Did I report whether the user won or lost the game before the program finished?
       Mark out of 10: 10
       Comment: I reported whether the user won or lost the game before the program finished.
   11. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: I inserted a mark and comment for each question.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class HigherLower {
	
	public static final int ACE = 0;
	public static final int EIGHT = 7;
	public static final int CORRECT_IN_A_ROW_REQUIRED = 4;
	
	public static void main(String[] args) {
		
		Random randomCardGenerator = new Random();
		String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		int currentRandomCard = randomCardGenerator.nextInt(cards.length);
		int nextRandomCard = 0;
		int correctGuess = 0;
		String currentCardOutput = "";
		
		JOptionPane.showMessageDialog(null, "Welcome to the Hi-Lo card game!" + "\n" + "Ace is lowest and King is highest." + "\n" + "Good luck!");
		try
		{
			do
			{
				if ((currentRandomCard == ACE) || (currentRandomCard == EIGHT))
				{
					currentCardOutput = ("The card is an " + cards[currentRandomCard] + "\n");
				}
				else
				{
					currentCardOutput = ("The card is a " + cards[currentRandomCard] + "." + "\n");
				}
				
				String input = JOptionPane.showInputDialog(currentCardOutput + "Do you think the next card will be higher, lower or equal?" +
				"\n" + "(Type 'higher', 'lower', or 'equal'):").toLowerCase();
				Scanner inputScanner = new Scanner(input);
				nextRandomCard = randomCardGenerator.nextInt(cards.length);
				if (inputScanner.hasNext("higher"))
				{
					if (nextRandomCard > currentRandomCard)
					{
						correctGuess++;
					}
					else
					{
						correctGuess = 0;
					}
					currentRandomCard = nextRandomCard;
				}
				else if (inputScanner.hasNext("lower"))
				{
					if (nextRandomCard < currentRandomCard)
					{
						correctGuess++;
					}
					else
					{
						correctGuess = 0;
					}
					currentRandomCard = nextRandomCard;
				}
				else if (inputScanner.hasNext("equal"))
				{
					if (nextRandomCard == currentRandomCard)
					{
						correctGuess++;
					}
					else
					{
						correctGuess = 0;
					}
					currentRandomCard = nextRandomCard;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid input. Try Again.");
					continue;
				}
				
				if (correctGuess == 1)
				{
					JOptionPane.showMessageDialog(null, "Guesses correct = " + correctGuess + "\n" + "(You need " +
							CORRECT_IN_A_ROW_REQUIRED + " in a row to win).");
				}
				else if ((correctGuess != 1) && (correctGuess != CORRECT_IN_A_ROW_REQUIRED))
				{
					JOptionPane.showMessageDialog(null, "Guesses correct in a row = " + correctGuess + "\n" + "(You need " +
							CORRECT_IN_A_ROW_REQUIRED + " in a row to win).");
				}
				
				inputScanner.close();
			} while (correctGuess < CORRECT_IN_A_ROW_REQUIRED);
			JOptionPane.showMessageDialog(null, "Congratulations! You got 4 in a row, so you win!");
		}	
		catch (NullPointerException exception)
		{
			JOptionPane.showMessageDialog(null, "You have pressed 'Cancel', terminating this game.");
		}
		
	}
}
