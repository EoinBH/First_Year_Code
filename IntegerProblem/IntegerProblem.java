import java.util.Scanner;
public class IntegerProblem {
	
	public static void main(String args[]) {
		
		int counter = 1;
		int currentNumber = 0;
		boolean quit = false;
		int[] numberArray = new int[0];
		Scanner inputScanner =  new Scanner(System.in);
		
		while (!quit)
		{
			System.out.println("Enter an integer to add to the array (or 'quit' to finish): ");
			inputScanner =  new Scanner(System.in);
			
			if (inputScanner.hasNextInt())
			{
				currentNumber = inputScanner.nextInt();
				
				int[] nextNumberArray = new int[numberArray.length + 1];
				nextNumberArray[counter - 1] = currentNumber;
				numberArray = nextNumberArray.clone();
				
				if (checkIfEven(numberArray) == true)
				{
					System.out.println("The magnitude of the range of values is " + findRangeMagnitude(numberArray) + ", and all values are even.");
				}
				else
				{
					System.out.println("The magnitude of the range of values is " + findRangeMagnitude(numberArray) + ", and not all values are even.");
				}
				 
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
			//counter++;
		}
	}

	
	
	public static boolean checkIfEven(int[] numberArray) {
		
		boolean isEven = false;
		boolean quit = false;
		while (!quit)
		{
			for (int index = 1; index < numberArray.length; index++)
			{
				if ((numberArray[index - 1] % 2) == 0)
				{
					isEven = true;
				}
				else
				{
					isEven = false;
					quit = true;
				}
			}
		}
		
		return isEven;
	}
	
	
	public static int findRangeMagnitude(int[] numberArray) {
		
		int minimumValue = 0;
		int maximumValue = 0;
		int temporaryValue = 0;
		int rangeMagnitude = 0;
		if (numberArray.length == 1)
		{
			rangeMagnitude = 0;
		}
		else
		{
			for (int index = 1; index < numberArray.length; index++)
			{
				if (index == 1)
				{
					minimumValue = numberArray[0];
				}
				else if (index == 2)
				{
					maximumValue = numberArray[1];
					if (minimumValue > maximumValue)
					{
						temporaryValue = minimumValue;
						minimumValue = maximumValue;
						maximumValue = temporaryValue;
						
					}
				}
				else
				{
					if (numberArray[index] > maximumValue)
					{
						maximumValue = numberArray[index];
					}
					else if (numberArray[index] < minimumValue)
					{
						minimumValue = numberArray[index];
					}
				}
			}
			rangeMagnitude = maximumValue - minimumValue;
		}
		return rangeMagnitude;
	}
	
}
