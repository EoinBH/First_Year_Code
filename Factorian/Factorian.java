import java.util.Scanner;

public class Factorian {
	public static void main(String[] args) {
		
		
		Scanner numberScanner = new Scanner(System.in);
		boolean quit = false;
		int number = 0;
		
		while (!quit) 
		{
			System.out.println("Input a number or type 'quit': ");
			
			if (numberScanner.hasNextInt())
			{
				number = numberScanner.nextInt();
			}
			else if (numberScanner.hasNext("quit"))
			{
				quit = true;
				break;
			}
			
			if (isFactorian(number) == true)
			{
				System.out.println("This number is a factorian number.");
			}
			else 
			{
				System.out.println("This number is not a factorian number.");
			}
				
		}
		
		
		numberScanner.close();
	}
	
	public static boolean isFactorian(int number) {
		
		int numberCopy = 0;
		numberCopy += number;
		numberCopy = computeFactorial(number % 10);
		if ((number / 10) != 0)
		{
			isFactorian(number);
		}
		
		return (numberCopy == number);
		

	}
	
	public static int computeFactorial(int number) {
		
		int numberFactorial = 0;
		if (number > 1)
		{
			numberFactorial = 1;
			numberFactorial = number * computeFactorial(number - 1);
		}
		else
		{
			numberFactorial = 1;
		}
		return numberFactorial;
	}
	
}