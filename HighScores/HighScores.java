import java.util.Scanner;
public class HighScores {
	
	public static void main(String[] args) {
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("How many high scores do you want to maintain? ");
		int numberOfScores = inputScanner.nextInt();
		double[] scores = new double[numberOfScores];
		initialiseHighScores(scores);
		boolean quit = false;
		while (!quit)
		{
			System.out.println("Enter a new score (or enter 'quit'): ");
			if ((inputScanner.hasNextDouble()) || (inputScanner.hasNextInt()))
			{
				double nextScore = inputScanner.nextDouble();
				if (higherThan(nextScore, scores) == true)
				{
					insertScore(nextScore,scores);
				}
				printHighScores(scores);
			}
			else if (inputScanner.hasNext("quit"))
			{
				quit = true;
			}
		}
		inputScanner.close();
	}

	public static void initialiseHighScores(double[] scores) {
		if (scores != null)
		{
			for(int counter = 0; counter < scores.length; counter++)
			{
				scores[counter] = 0;
			}
		}
		else
		{
			
		}
	}
	
	public static void printHighScores(double[] scores) {
		
		String highScores = "";
		for (int counter = 0; counter < scores.length; counter++)
		{
			if (scores[counter] != 0)
			{
				highScores += ("" + scores[counter] + ", ");
			}
		}
		System.out.println("The High Scores are " + highScores);
	}
	
	public static boolean higherThan(double nextScore, double[] scores) {
		
		for (int counter = 0; counter < scores.length; counter++)
		{
			if (nextScore > scores[counter])
			{
				return (true);
			}
		}
		return (false);
	}
	
	public static void insertScore(double nextScore, double[] scores) {
		
		//insertion sort algorithm
		int counter = 0;
		int position = 0;
		for (counter = 0; counter < scores.length; counter++)
		{
			if (nextScore > scores[counter])
			{
				if (counter == ((scores.length) - 1))
				{
					position = counter;
				}
				if (counter == ((scores.length) - 2))
				{
					if (nextScore > scores[(scores.length) - 1])
						{
							position = counter + 1;
						}
					else
						{
							position = counter;
						}
				}
				else
				{
					position = counter + 1;
				}
			}
		}
		for (counter = 0; counter < position; counter++)
		{
			scores[counter] = scores[counter + 1];
		}
		scores[position] = nextScore;
	}
	
	
}
