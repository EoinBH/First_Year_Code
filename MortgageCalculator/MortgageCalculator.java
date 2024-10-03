/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment: I used meaningful, easily understood and properly formatted variable names and constants.
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment: I indented my code appropriately.
 3. Did I implement the main line correctly with a loop which continues using the user says "no" ?
       Mark out of 10: 10
        Comment: I implemented a main line which loops until the user says "no".
 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
       Mark out of 10: 10
        Comment: I obtained the relevant inputs from the user and produced the relevant outputs using the specified prompts & formats.
 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood
 	(4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment: I implemented the readDoubleFromUser function correctly and in an easily understood manner.
 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood
 	(4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment: I implemented the calculateMonthlyRepayment function correctly and in an easily understood manner.
 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easily understood
 	(4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment: I implemented the calculateMonthsToRepayMortgage function correctly and in an easily understood manner.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: I provided a mark and comment for every question.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 

import java.util.Scanner;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;
public class MortgageCalculator {
	
	public static final int DEFAULT_MORTGAGE_DURATION = 20;
	public static final char EURO = '\u20AC';
	
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "Welcome to the mortgage calculator.");
		boolean quit = false;
		boolean validInput = false;
		double principal = 0;
		double annualInterestRate = 0;
		DecimalFormat rounding = new DecimalFormat(".00");
		
		while (!quit)
		{
			validInput = false;
			while (!validInput)
			{
				String principalPrompt = ("Please enter the mortgage amount: ");
				principal = readDoubleFromUser(principalPrompt);
				if (principal <= 0)
				{
					JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
				}
				else
				{
					validInput = true;
				}
			}
			
			validInput = false;
			while (!validInput)
			{
				String annualInterestRatePrompt = JOptionPane.showInputDialog("Please enter the annual interest rate (APR): ");
				Scanner annualInterestRateScanner = new Scanner(annualInterestRatePrompt);
				annualInterestRate = annualInterestRateScanner.nextDouble();
				if (annualInterestRate <= 0)
				{
					JOptionPane.showMessageDialog(null, "Please enter a positive amount.");
				}
				else
				{
					validInput = true;
				}
				annualInterestRateScanner.close();
			}
			
			double monthlyRepayment = calculateMonthlyRepayment(principal, DEFAULT_MORTGAGE_DURATION, annualInterestRate);
			
			JOptionPane.showMessageDialog(null, "Assuming a " + DEFAULT_MORTGAGE_DURATION +
					" year term, the monthly repayments would be " + EURO + rounding.format(monthlyRepayment));
			
			String affordableMonthlyRepaymentPrompt = JOptionPane.showInputDialog("How much can you afford to pay per month? ");
			Scanner affordableMonthlyRepaymentScanner = new Scanner(affordableMonthlyRepaymentPrompt);
			double affordableMonthlyRepayment = affordableMonthlyRepaymentScanner.nextDouble();
			affordableMonthlyRepaymentScanner.close();
			
			int monthsToRepayMortgage = calculateMonthsToRepayMortgage(principal, affordableMonthlyRepayment, annualInterestRate);
			int yearsToRepayMortgage = (monthsToRepayMortgage / 12);
			monthsToRepayMortgage %= 12;
			
			String months = "";
			String years = "";
			
			if ((yearsToRepayMortgage == 1) && (monthsToRepayMortgage == 1))
			{
				years = "year";
				months = "month";
			}
			else if (yearsToRepayMortgage == 1)
			{
				years = "year";
				months = "months";
			}
			else if (monthsToRepayMortgage == 1)
			{
				years = "years";
				months = "month";
			}
			else
			{
				years = "years";
				months = "months";
			}
			
			if (affordableMonthlyRepayment <= (principal * ((annualInterestRate / 12) / 100)))
			{
				JOptionPane.showMessageDialog(null, "You will never pay off the mortgage at this rate.");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "If you pay " + EURO + rounding.format(affordableMonthlyRepayment) +
						" per month your mortgage would be paid off in " + yearsToRepayMortgage + " " + years + " and " +
						monthsToRepayMortgage + " " + months + ".");
			}
			
			validInput = false;
			while (!validInput)
			{
				String recalculationPrompt = JOptionPane.showInputDialog("Would you like to use the mortgage calculator again (yes/no)?" );
				Scanner recalculationScanner = new Scanner(recalculationPrompt);
				if (recalculationScanner.hasNext("yes"))
				{
					validInput = true;
				}
				else if (recalculationScanner.hasNext("no"))
				{
					validInput = true;
					quit = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
				}
				recalculationScanner.close();
			}
		} 
	}
	
	
	public static double readDoubleFromUser(String principalPrompt) {
			
		String principalInput = "";
		boolean validInput = false;
		double principal = 0.0;
		while (!validInput)
		{
			principalInput = JOptionPane.showInputDialog(principalPrompt);
			Scanner principalScanner = new Scanner(principalInput);
			if (principalScanner.hasNextDouble())
			{
				principal = principalScanner.nextDouble();
				principalScanner.close();
				validInput = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
			}
		}
		return (principal);
	}
	
	
	public static double calculateMonthlyRepayment(double principal, int DEFAULT_MORTGAGE_DURATION, double annualInterestRate) {
			
		double duration = DEFAULT_MORTGAGE_DURATION;
		double monthlyRepayment = ((principal) * ((annualInterestRate / 12) / 100)) /
				(1 - Math.pow(1 + ((annualInterestRate / 12) / 100),(-duration * 12)));
		return(monthlyRepayment);
	}
	
	
	public static int calculateMonthsToRepayMortgage(double principal, double affordableMonthlyRepayment, double annualInterestRate) {
		
		double rate = ((annualInterestRate / 12) / 100);
		
		return  (int) Math.ceil(Math.log(affordableMonthlyRepayment / (affordableMonthlyRepayment - (principal * rate))) /
				(Math.log(1 + rate)));
	}
}
