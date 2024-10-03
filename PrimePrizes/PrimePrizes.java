import java.util.Scanner;
import javax.swing.JOptionPane;

public class PrimePrizes {
	
	public static void main(String[] args) {
	
	int divisor = 2;
	int competitors = 0;
	int finishingPlace = 4;
	int divisionTest = 0;
	
	Double divisionTestDouble = 0.0;
	Double finishingPlaceDouble = 4.0;
	Double divisorDouble = 2.0;
	
	boolean prime = true;
	Scanner inputScanner = new Scanner(System.in);
	
	System.out.println("Input the number of competitors in the 'Prime Prizes' race: ");
	competitors = inputScanner.nextInt();
	if (competitors > 3)
	{
		while (finishingPlaceDouble <= competitors)
		{
			while ((divisorDouble <= (Math.sqrt(finishingPlaceDouble))) && (prime == true))
			{
				
				divisionTestDouble = finishingPlaceDouble % divisorDouble; 
				divisorDouble++;
				if (divisionTestDouble == 0)
				{
					prime = false;
				}
			}
			if (prime == true)
			{
				System.out.println(finishingPlaceDouble + " is prime.");
			}
			finishingPlaceDouble++;
			prime = true;
		}
		System.out.println("Prime calcluations finished.");
	}
	//competitors <= 3
	
	inputScanner.close();
	}
}
