import javax.swing.JOptionPane;
import java.util.Scanner;

public class centraltendency {
    public static void main(String args[]) {
    	
    	String numberInput = JOptionPane.showInputDialog("Input three numbers separated by spaces");
    	Scanner numberScanner = new Scanner(numberInput);
    	double number1 = numberScanner.nextDouble();
    	double number2 = numberScanner.nextDouble();
    	double number3 = numberScanner.nextDouble();
    	numberScanner.close();
    	
    	double average = (number1 + number2 + number3) /  3;
    	
    	double deviation = Math.sqrt((((number1 - average) * (number1 - average)) +
    			((number2 - average) * (number2 - average)) +
    			((number3 - average) * (number3 - average))) / 3);
    	
    	JOptionPane.showMessageDialog(null, "The average of these three numbers is "+ average);
    	JOptionPane.showMessageDialog(null, "The standard deviation of these three numbers is "+ deviation);
   
    }

}
