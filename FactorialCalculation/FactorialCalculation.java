import java.util.Scanner;

public class FactorialCalculation {
	public static void main(String[] args) {
		
		
		Scanner numberScanner = new Scanner(System.in);
		
		System.out.println("Input a number: ");
		int number = numberScanner.nextInt();
		
		System.out.println("The factorial of your number is " + getFactorial(number));
		numberScanner.close();
	}
	
	
	public static int getFactorial(int number) {
		
		int numberFactorial = 0;
		if (number > 1)
		{
			numberFactorial = 1;
			numberFactorial = number * getFactorial(number - 1);
		}
		else
		{
			numberFactorial = 1;
		}
		return numberFactorial;
	}
	
}
