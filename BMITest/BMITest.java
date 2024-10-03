
import java.util.Scanner;
import java.text.DecimalFormat;

public class BMITest {
	
	public static final double OVERWEIGHT_THRESHOLD = 25.0;
	
	public static void main(String[] args) {
		
		double weight = 0;
		double height = 0;
		double BMI = 0;
		double averageBMI = 0;
		double totalBMI = 0;
		double percentageOverweight = 0;
		boolean quit = false;
		double counter = 1;
		double overweightCounter = 0;
		
		
		DecimalFormat rounding = new DecimalFormat("0.00");
		Scanner inputScanner = new Scanner(System.in);
		
		for (double currentBMI = BMI; (!quit); counter++)
		{
			System.out.println("Enter the person's height in metres (or 'quit'): ");
			inputScanner = new Scanner(System.in);
			if (inputScanner.hasNextDouble())
			{
				height = inputScanner.nextDouble();
				
				System.out.println("Enter the person's weight in kilograms (or 'quit'): ");
				weight = inputScanner.nextDouble();
				
				//if (height > 0)
				//{
					currentBMI = weight/(height * height);
					totalBMI += currentBMI;
				//}
				//else
				//{
					//currentBMI = 0;
					//totalBMI += currentBMI;
				//}
		
				if (counter > 1)
				{
					averageBMI = totalBMI/counter;
				}
				else
				{
					averageBMI = currentBMI;
				}
				//percentageOverweight = ((overweightCounter/counter) * 100);
				
				if (currentBMI >= OVERWEIGHT_THRESHOLD)
				{
					overweightCounter++;
					percentageOverweight = ((overweightCounter/counter) * 100);
				}
				
				System.out.println("The average BMI is " + rounding.format(averageBMI) + " and " + rounding.format(percentageOverweight)
				+ "% of the people are overweight or obese." + "\n");
			}
			else if (inputScanner.hasNext("quit"))
			{
				quit = true;
			}
			else
			{
				System.out.println("Invalid input. Try again.");
				//counter = counter - 1;
				continue;
			}
			
		}
		inputScanner.close();
	}
}
