import java.util.Scanner;
import javax.swing.JOptionPane;

public class ComputePi {
	
	public static void main(String[] args) {
		
		
		String termsInput = JOptionPane.showInputDialog("Enter the number of decimal places to which you want to calculate Pi:");
		Scanner termScanner = new Scanner( termsInput );
		double terms = termScanner.nextDouble();
		double total = 3.0;
		double denominatorOne = 2.0;
		double denominatorTwo = 3.0;
		double denominatorThree = 4.0;
		double decimal = 0;
		int counter = 0;
		
		do
		{
			decimal = (4/((denominatorOne)*(denominatorTwo)*(denominatorThree)));
			if ((counter == 0) || (counter %2 == 0))
			{
				total = total + decimal;
				denominatorOne = denominatorOne + 2.0;
				denominatorTwo = denominatorTwo + 2.0;
				denominatorThree = denominatorThree + 2.0;
				counter = counter + 1;
			}
			else
			{
				total = total - decimal;
				denominatorOne = denominatorOne + 2.0;
				denominatorTwo = denominatorTwo + 2.0;
				denominatorThree = denominatorThree + 2.0;
				counter = counter + 1;
			}
		} while (counter < terms);
		JOptionPane.showMessageDialog(null, total);
		termScanner.close();
	}

}
