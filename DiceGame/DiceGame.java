/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: Yes, I have correctly defined the ResolveBet method.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: Yes, my program presents the amount of cash in the wallet and prompts the user for a bet.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: Yes, my program ensures the bet amount is not greater than the cash in the wallet.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: Yes, my program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: Yes, my program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: Yes, my program outputs the results and updates the wallet accordingly.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: Yes. I ask the user how much cash they have and create a Wallet object and put this amount into it.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: Yes, my program continuously loops until the user either enters quit or the cash in the wallet is 0.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: Yes, I prompt the user to select any of the four bet types.
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: Yes, my program calls resolveBet for each bet type entered.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: Yes, at the end of the game my program presents a summary message regarding winnings and losses.

 Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;
public class DiceGame {
	
	public static final char EURO = '\u20AC';
	public static boolean end = false;
	
	public static void main(String[] args) {
		double userMoney = 0.0;
		Scanner inputScanner = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Welcome to the Chuck-a-Luck Dice Game." + "\n" + "Type 'quit' at any point to end the game.");
		
		while (!quit)
		{
			System.out.println("How much money do you have? (" + EURO + "): ");
			if (!inputScanner.hasNextDouble())
			{
				if (inputScanner.hasNext("quit"))
				{
					end = true;
					quit = true;
				}
				if (end == false)
				{
					System.out.println("Invalid input. Please try again.");
					inputScanner.next();
				}
			}
			else
			{
				userMoney = inputScanner.nextDouble();
				if (userMoney > 0)
				{
					quit = true;
				}
				else
				{
					System.out.println("Invalid input. Please try again.");
				}
			}
		}
		
		Wallet userWallet = new Wallet();
		userWallet.put(userMoney);
		quit = false;
		
		while (!quit)
		{
			inputScanner = new Scanner(System.in);
			if (end == false)
			{
				System.out.println("Enter your selected bet type, (Triple, Field, High or Low): ");
				if (inputScanner.hasNext("Triple"))
				{
					resolveBet("triple", userWallet);
					if (end == true)
					{
						quit = true;
					}
				}
				else if (inputScanner.hasNext("Field"))
				{
					resolveBet("field", userWallet);
					if (end == true)
					{
						quit = true;
					}
				}				
				else if (inputScanner.hasNext("High"))
				{
					resolveBet("high", userWallet);
					if (end == true)
					{
						quit = true;
					}
				}				
				else if (inputScanner.hasNext("Low"))
				{
					resolveBet("low", userWallet);
					if (end == true)
					{
						quit = true;
					}
				}
				else if (inputScanner.hasNext("quit"))
				{
					end = true;
					quit = true;
				}
				else
				{
					System.out.println("Invalid input. Please try again.");
					inputScanner.next();
				}
			}
			else
			{
				quit = true;
			}
		}
		inputScanner.close();
		System.out.println("The Chuck-a-Luck Dice Game has ended." + "\n" +
		"At the beginning of the game, you had " + EURO + userMoney + " in your wallet." + "\n" + "You now have " + EURO +
		userWallet.check() + " in your wallet.");
	}
	
	public static void resolveBet(String bet, Wallet userWallet) {
		System.out.println("You currently have " + EURO + userWallet.check() + " in your wallet.");
		Scanner betScanner = new Scanner(System.in);
		double currentBet = 0.0;
		boolean quit = false;
		
		while (!quit)
		{
			System.out.println("Enter how much you would like to bet (" + EURO + "): ");
			if (!betScanner.hasNextDouble())
			{
				if (betScanner.hasNext("quit"))
				{
					end = true;
					quit = true;
				}
				if (end == false)
				{
					System.out.println("Invalid input. Please try again.");
					betScanner.next();
				}
			}
			else
			{
				currentBet = betScanner.nextDouble();
				if (currentBet <= userWallet.check())
				{
					quit = true;
				}
				else
				{
					System.out.println("Invalid input. Please try again.");
				}
			}
		}
		
		if (end == false)
		{
			Dice d1 = new Dice();
			int r1 = d1.roll();
			Dice d2 = new Dice();
			int r2 = d2.roll();		
			Dice d3 = new Dice();
			int r3 = d3.roll();
			System.out.println("Dice 1 result is: " + r1);
			System.out.println("Dice 2 result is: " + r2);
			System.out.println("Dice 3 result is: " + r3);
			if (compareRoll(r1, r2, r3, bet) == true)
			{
				System.out.println("You win.");
				userWallet.put(currentBet);
				
				if (bet != "triple")
				{
					userWallet.put(currentBet);
				}
				else
				{
					userWallet.put(currentBet * 30);
				}
			}
			else
			{
				System.out.println("You lose.");
				if (userWallet.get(currentBet) == true)
				{
					if (userWallet.check() == 0.0)
					{
						end = true;
					}
				}
				else
				{
					end = true;
				}
			}
		}
	}
	
	public static boolean compareRoll(int r1, int r2, int r3, String bet) {
		boolean triple = false;
		int totalRoll = r1 + r2 + r3;
		
		if (((r1 == r2) && (r2 == r3)) && (r1 != 1) && (r1 != 6))
		{
			triple = true;
		}
		
		switch (bet) {
		case "triple":
			if (triple == true)
			{
				return true;
			}
			else
			{
				return false;
			}
		case "field":
			if ((totalRoll < 8) || (totalRoll > 12))
			{
				return true;
			}
			else
			{
				return false;
			}
		case "high":
			if ((totalRoll > 10) && (triple == false))
			{
				return true;
			}
			else
			{
				return false;
			}
		case "low":
			if ((totalRoll < 11) && (triple == false))
			{
				return true;
			}
			else
			{
				return false;
			}
		default:
			return true;
		}
	}
	
}


