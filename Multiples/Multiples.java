import java.util.Scanner;
import java.text.DecimalFormat;

public class Multiples {
	public static void main(String args[]) {
		
		Scanner numberInput = new Scanner(System.in);
		System.out.print("Input a starting number: ");
		double firstNumber = numberInput.nextDouble();
		System.out.print("Input a number limit: ");
		double lastNumber = numberInput.nextDouble();
		int counter = 1;
		DecimalFormat rounding = new DecimalFormat(".000");
		
		if (firstNumber >= 1)
		{
			System.out.print("The multiples of " + firstNumber + " up to "  + lastNumber + " are: ");
			for (double multiple = firstNumber; ((multiple < lastNumber) && ((lastNumber - multiple) >= firstNumber)); counter++)
			{
				multiple = firstNumber * counter;
				System.out.print("\n" + rounding.format(multiple));
			}
		}
		else
			System.out.print("You have entered an invalid number.");
		
		numberInput.close();
		
	}
}