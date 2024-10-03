import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
	
	public static final Scanner SCANNER = new Scanner(System.in);
	
	public C4HumanPlayer(int colour) {
		setColour(colour);
	}
	
	@Override
	public int selectColumn() {
		boolean quit = false;
		int column = 0;
		while (!quit)
		{
			if (isRed() == true)
			{
				System.out.println("Red Player, select a column (Type a number from 1-7): ");
			}
			else
			{
				System.out.println("Yellow Player, select a column (Type a number from 1-7): ");
			}
			if (SCANNER.hasNextInt())
			{
				column = SCANNER.nextInt();
				quit = true;
			}
			else
			{
				System.out.println("Invalid input. Try again.8");
				SCANNER.next();
			}
		}
		return (column-1);
	}
}
