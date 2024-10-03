import java.util.Scanner;

public class MaximumMinimum {
	public static void main(String[] args) {
	
	int firstNumber = 0;
	int nextNumber = 0;
	int lastNumber = 0;
	int counter = 0;
	Scanner numberScanner = new Scanner(System.in);
	System.out.print("Input a list of numbers, separated by spaces.");
	
	do
	{
		if (numberScanner.hasNextInt())
		{
			System.out.print("true");
			nextNumber = numberScanner.nextInt();
			if (counter == 0)
			{
				firstNumber = nextNumber;
				counter++;
				System.out.print("" + firstNumber + "" + lastNumber);
				continue;
			}
			else if (counter == 1)
			{
				if (nextNumber < firstNumber)
				{
					lastNumber = firstNumber;
					firstNumber = nextNumber;
					counter++;
					System.out.print("" + firstNumber + "" + lastNumber);
					continue;
				}
				else if (nextNumber > firstNumber)
				{
					lastNumber = nextNumber;
					counter++;
					System.out.print("" + firstNumber + "" + lastNumber);
					continue;
				}
					
			}
			
			if (nextNumber < firstNumber)
			{
				firstNumber = nextNumber;
				counter++;
				System.out.print("" + firstNumber + "" + lastNumber);
			}
			else if (nextNumber > lastNumber)
			{
				lastNumber = nextNumber;
				counter++;
				System.out.print("" + firstNumber + "" + lastNumber);
			}
		}
		else
		{
			System.out.print("The minimum number is " + firstNumber + ", and the maximum number is " + lastNumber + ".");
		}
		
	} while (counter < 3);
	
	System.out.print("The minimum number is " + firstNumber + ", and the maximum number is " + lastNumber + ".");
	
	numberScanner.close();
		
	}

}
