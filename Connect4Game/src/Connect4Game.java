/* SELF ASSESSMENT

Connect4Game class (35 marks): 35
My class creates references to the Connect 4 Grid and two Connect 4 Players.
It asks the user whether he/she would like to play/quit inside a loop.
If the user decides to play then:
1. Connect4Grid2DArray is created using the Connect4Grid interface,
2. the two players are initialised - must specify the type to be ConnectPlayer,
and 3. the game starts.
In the game, I ask the user where he/she would like to drop the piece.
I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: My class creates references to the Connect 4 Grid and two Connect 4 Players.
It asks the user to select a game mode inside a loop.  Connect4Grid2DArray is created using the Connect4Grid interface,
the two players are initialised and the game starts. In the game, I ask the user where he/she would like to drop the piece.
I perform checks by calling methods in the Connect4Grid interface. Finally I perform a check to determine a win.

Connect4Grid interface (10 marks): 10
I define all 7 methods within this interface.
Comment: Yes, I define all 7 methods within this interface.

Connect4Grid2DArray class (25 marks): 25
My class implements the Connect4Grid interface.
It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid.
It provides an implementation of the method to check whether the column to drop the piece is full.
It provides an implementation of the method to drop the piece. It provides an implementation of the method to check whether there is a win.
Comment: My class implements the Connect4Grid interface by creating a grid using a 2D array Implementation of the method.
This then checks whether the column to drop the piece is valid. It provides an implementation of the method to check whether the column to drop the piece is full.
It provides an implementation of the method to drop the piece. It provides an implementation of the method to check whether there is a win.

ConnectPlayer abstract class (10 marks): 10
My class provides at least one non-abstract method and at least one abstract method. 
Comment: My class provides two non-abstract methods and one abstract method.

C4HumanPlayer class (10 marks): 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: My class extends the ConnectPlayer class and overrides the abstract method. It provides the Human player functionality.

C4RandomAIPlayer class (10 marks): 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: My class extends the ConnectPlayer class and overrides the abstract method. It provides AI player functionality.

Total Marks out of 100: 100

*/

import java.util.Scanner;
public class Connect4Game {
	
	public static final Scanner SCANNER = new Scanner(System.in);
	private Connect4Grid2DArray grid;
	private ConnectPlayer playerRed;
	private ConnectPlayer playerYellow;
	private int red = 0;
	private int yellow = 1;
	
	public Connect4Game(int mode) {
		if (mode == 1)
		{
			playerRed = new C4HumanPlayer(red);
			playerYellow = new C4RandomAIPlayer(yellow);
			grid = new Connect4Grid2DArray();
		}
		else
		{
			playerRed = new C4HumanPlayer(red);
			playerYellow = new C4HumanPlayer(yellow);
			grid = new Connect4Grid2DArray();
		}
	}
	
	public static void main(String[] args) {
		boolean quit = false;
		int mode = 0;
		while (!quit)
		{
			System.out.println("Welcome to the Connect4 Game!" + "\n" +
					"Type '1' for single player mode, (play against AI), or type '2' for 2 player mode: ");
			if (SCANNER.hasNextInt())
			{
				mode = SCANNER.nextInt();
				if ((mode == 1) || (mode == 2))
				{
					quit = true;
				}
				else
				{
					System.out.println("Invalid input. Try again.");
				}
			}
			else
			{
				System.out.println("Invalid input. Try again.");
				SCANNER.next();
			}
		}
		Connect4Game newGame = new Connect4Game(mode);
		boolean redWins = false;
		boolean tie = false;
		boolean endGame = false;
		boolean roundZero = true;
		boolean yellowTurn = false;
		while (!endGame)
		{
			if (roundZero)
			{
				System.out.println("Board:" + "\n" + newGame.grid.toString());
			}
			roundZero = false;
			quit = false;
			int column = 0;
			while (!quit)
			{
				if (!yellowTurn)
				{
					column = newGame.playerRed.selectColumn();
				}
				else
				{
					column = newGame.playerYellow.selectColumn();
				}
				if (newGame.grid.isValidColumn(column) == true)
				{
					if (newGame.grid.isColumnFull(column) == true)
					{
						quit = true;
					}
				}
				else
				{
					System.out.println("Invalid input. Try again.");
				}
			}
			if (!yellowTurn)
			{
				newGame.grid.dropPiece(newGame.playerRed, column);
			}
			else
			{
				newGame.grid.dropPiece(newGame.playerYellow, column);
			}
			System.out.println("Board:" + "\n" + newGame.grid.toString());
			if (newGame.grid.didLastPieceConnect4())
			{
				if (!yellowTurn)
				{
					redWins = true;
				}
				else
				{
					redWins = false;
				}
				endGame = true;
			}
			if (newGame.grid.isGridFull() && !endGame)
			{
				tie = true;
				endGame = true;
			}
			if ((mode == 1) && !endGame)
			{
				quit = false;
				while (!quit)
				{
					column = newGame.playerYellow.selectColumn();
					if (newGame.grid.isValidColumn(column) == true)
					{
						if (newGame.grid.isColumnFull(column) == true)
						{
							System.out.println("Yellow player (computer) has taken a turn.");
							quit = true;
						}
					}
				}
				newGame.grid.dropPiece(newGame.playerYellow, column);
				System.out.println("Board:" + "\n" + newGame.grid.toString());
				if (newGame.grid.didLastPieceConnect4())
				{
					redWins = false;
					endGame = true;
				}
				if (newGame.grid.isGridFull())
				{
					tie = true;
					endGame = true;
				}
			}
			else
			{
				if (!yellowTurn)
				{
					yellowTurn = true;
				}
				else
				{
					yellowTurn = false;
				}
			}
		}
		if (redWins)
		{
			System.out.println("Red Player wins!");
		}
		else if (!redWins)
		{
			System.out.println("Yellow Player wins!");
		}
		else if (tie)
		{
			System.out.println("Tie Game!");
		}
	}
}
