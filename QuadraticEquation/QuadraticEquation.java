import java.util.Scanner;

public class QuadraticEquation {
	
	public static void main(String[] args) {
		
		double firstCoefficient = 0;
		double secondCoefficient = 0;
		double thirdCoefficient = 0;
		boolean quit = false;
		int counter = 1;
		Scanner coefficientScanner = new Scanner(System.in);
		
		for (; (!quit); counter++)
		{
			System.out.print("Enter the coefficients of your second order polynomial separated by spaces (or enter quit):");
			coefficientScanner = new Scanner(System.in);
			if (coefficientScanner.hasNextDouble())
			{
				firstCoefficient = coefficientScanner.nextDouble();
				secondCoefficient = coefficientScanner.nextDouble();
				thirdCoefficient = coefficientScanner.nextDouble();
				
				if (((secondCoefficient * secondCoefficient) - 4 * (firstCoefficient * thirdCoefficient)) >= 0)
				{
					double rootOne = (-secondCoefficient + Math.sqrt((secondCoefficient * secondCoefficient)
							- 4 * (firstCoefficient * thirdCoefficient))) / (2 * (firstCoefficient));
					double rootTwo = (-secondCoefficient - Math.sqrt((secondCoefficient * secondCoefficient)
							- 4 * (firstCoefficient * thirdCoefficient))) / (2 * (firstCoefficient));
					if (rootOne == rootTwo)
					{
						System.out.print("(Calculation " + counter + "):" + " This equation has one root, which is x = " + rootOne + "\n");
					}
					else
					{
						System.out.print("(Calculation " + counter + "):" + "The roots of this equation are x = " + rootOne + " and x = " + rootTwo + "\n");
					}
				}
				else if (((secondCoefficient * secondCoefficient) - 4 * (firstCoefficient * thirdCoefficient)) < 0)
				{
					System.out.print("(Calculation " + counter + "):" + " This equation has imaginary roots." + "\n");
				}
			}
			else if (coefficientScanner.hasNext("quit"))
			{
				quit = true;
			}
			else if (coefficientScanner.hasNext())
			{
				System.out.print("Invalid input. Try again." + "\n");
				continue;
			}
		}
		coefficientScanner.close();
	}
}
