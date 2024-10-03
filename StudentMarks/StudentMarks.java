import java.util.Scanner;

public class StudentMarks {
	
	public static final double FIRST_CLASS_HONOURS = 70.0;

	public static void main(String[] args) {
		
		boolean quit = false;
		double currentMark = 0.0;
		double[] marks = new double[1];
		double[] marksCopy = new double[1];
		int counter = 0;
		Scanner inputScanner = new Scanner(System.in);
		
		while(!quit)
		{
			System.out.println("Enter a student percentage: ");
			inputScanner = new Scanner(System.in);
			if (inputScanner.hasNextDouble() || inputScanner.hasNextInt())
			{
				currentMark = inputScanner.nextDouble();
			}
			else if (inputScanner.hasNext("quit"))
			{
				quit = true;
			}
			else 
			{
				System.out.println("Invalid input. Please try again.");
			}
			inputScanner.close();
			
			if (counter == 0)
			{
				marksCopy = new double[marks.length];
			}
			else
			{
				marksCopy = new double[marks.length + 1];
			}
			marksCopy = new double[marks.length + 1];
			marksCopy[marksCopy.length - 1]  = currentMark;
			marks = marksCopy.clone();
			
			System.out.println(countFirstClassHonours(marks) + " students obtained first class honours. The highest mark was " + determineBestMark(marks));
			counter++;
		}
	}
	
	
	public static double determineBestMark(double[] marks) {
		
		double bestMark = 0;
		for(int index = 0; index < marks.length; index++)
		{
			if (marks[index] > bestMark)
			{
				bestMark = marks[index];
			}
		}
		return bestMark;
	}
	
	
	public static int countFirstClassHonours(double[] marks) {
		
		int counter = 0;
		for(int index = 0; index < marks.length; index++)
		{
			if (marks[index] >= FIRST_CLASS_HONOURS)
			{
				counter++;
			}
		}
		return counter;
	}
	
	
	
	
	
}





