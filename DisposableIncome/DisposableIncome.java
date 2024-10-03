/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable and CONSTANT names? 
       Mark out of 10: 10
       Comment: I named the rate of tax as TAX_RATE, the euro symbol as EURO, the average disposable income as AVERAGE_DISPOSABLE_INCOME
       and the percentage to which the user can compare their disposable income as ANALYSIS_PERCENT. These constants are meaningful and easily understood.
   2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)?
       Mark out of 10: 10
       Comment: My variables and constants are named correctly according to these conventional formats.
   3. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: I kept my code neat with correct use of indentation.
   4. Did I read the input correctly from the user using appropriate questions?
       Mark out of 15: 15
       Comment: I used appropriate questions to ask for input from the user and the program reads the user's input correctly.
   5. Did I compute the disposable income and disposable income percentage correctly, and output it in the correct format?
       Mark out of 15: 15
       Comment: I computed the correct disposable income and disposable income percentage and output them using the correct format.
  6. Did I use an appropriate series of if statements to generate the income analysis to the user?
       Mark out of 25: 25
       Comment: I used an appropriate series of if statements to generate a useful income analysis for the user.
   7. Did I provide the correct output for each possibility in an easy-to-read format?
       Mark out of 10: 10
       Comment: I provided correct outputs for each possibility in an easy-to-read format.
   8. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: I provided a mark and comment for each question, completing this self-assessment properly.
   Total Mark out of 100 (Add all the previous marks): 100
*/

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.text.DecimalFormat;

public class DisposableIncome {
	
	public static final double TAX_RATE = 0.35;
	public static final char EURO = '\u20AC';
	public static final int AVERAGE_DISPOSABLE_INCOME = 500;
	public static final double ANALYSIS_PERCENT = 0.5;
	
    public static void main(String args[]) {
    	
    	String grossInput = JOptionPane.showInputDialog("How much are you paid per month before tax? (in " + EURO + ")");
    	Scanner valueScanner = new Scanner(grossInput);
    	double grossPay = valueScanner.nextDouble();
    	valueScanner.close();
    	
    	String accomodationCostInput = JOptionPane.showInputDialog("How much do you pay for accomodation every month? (in " + EURO + ")");
    	valueScanner = new Scanner(accomodationCostInput);
    	double accomodationCost = valueScanner.nextDouble();
    	valueScanner.close();
    	
    	String commuteCostInput = JOptionPane.showInputDialog("How much is your monthly commute cost? (in " + EURO + ")");
    	valueScanner = new Scanner(commuteCostInput);
    	double commuteCost = valueScanner.nextDouble();
    	valueScanner.close();
    	
    	String foodCostInput = JOptionPane.showInputDialog("How much do you spend on food per month? (in " + EURO + ")");
    	valueScanner = new Scanner(foodCostInput);
    	double foodCost = valueScanner.nextDouble();
    	valueScanner.close();
    
    	double afterTax = (grossPay - (grossPay * TAX_RATE));
    	double disposableIncome = (afterTax - accomodationCost - commuteCost - foodCost);
    	double percentageSalary = 0;
    	
    	if ((disposableIncome == 0) || (grossPay == 0))
    	{
    		percentageSalary = 0;
    	}
    	else
    	{
    		percentageSalary = ((disposableIncome / grossPay) * 100);
    	}
    	
    	DecimalFormat rounding = new DecimalFormat(".00");
    	
    	String outputMessage = "At a tax rate of " + (TAX_RATE * 100) + "%, your monthly Disposable Income is "
    			+ EURO + rounding.format(disposableIncome) + "\n" + "This is " 
    			+ rounding.format(percentageSalary) + "% of your salary.";
    	
    	String outputAnalysisMessage = "";
    	
    	if (disposableIncome > ((AVERAGE_DISPOSABLE_INCOME * ANALYSIS_PERCENT) + AVERAGE_DISPOSABLE_INCOME))
    	{
    		outputAnalysisMessage = "Your monthly Disposable Income is over " + (ANALYSIS_PERCENT * 100) + "% above average.";
    	}
    	else if (disposableIncome == ((AVERAGE_DISPOSABLE_INCOME * ANALYSIS_PERCENT) + AVERAGE_DISPOSABLE_INCOME))
    	{
    		outputAnalysisMessage = "Your monthly Disposable Income is exactly " + (ANALYSIS_PERCENT * 100) + "% above average.";
    	}
    	else if (disposableIncome > AVERAGE_DISPOSABLE_INCOME)
    	{
    		outputAnalysisMessage = "Your monthly Disposable Income is above average.";
    	}
    	else if (disposableIncome == AVERAGE_DISPOSABLE_INCOME)
    	{
    		outputAnalysisMessage = "Your monthly Disposable Income is exactly on average.";
    	}
    	else if (disposableIncome > (AVERAGE_DISPOSABLE_INCOME * ANALYSIS_PERCENT))
    	{
    		outputAnalysisMessage = "Your monthly Disposable Income is below average.";
    	}
    	else if (disposableIncome == (AVERAGE_DISPOSABLE_INCOME * ANALYSIS_PERCENT))
    	{
    		outputAnalysisMessage = "Your monthly Disposable Income is exactly " + (ANALYSIS_PERCENT * 100) + "% below average.";
    	}
    	else if (disposableIncome > 0)
    	{
    		outputAnalysisMessage = "Your monthly Disposable Income is over " + (ANALYSIS_PERCENT * 100) + "% below average.";
    	}
    	else if (disposableIncome <= 0)
    	{
    		outputAnalysisMessage = "";
    	}
    		
    	JOptionPane.showMessageDialog(null, outputMessage + "\n" + outputAnalysisMessage);
    	
    	
    }
    
}