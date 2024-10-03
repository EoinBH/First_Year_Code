
import javax.swing.JOptionPane;
import java.util.Scanner;

public class wages {
    public static void main(String args[]) {
    	String rateInput = JOptionPane.showInputDialog("What is your wage rate per hour, in " + '\u20AC' + " ? (Decimal form)");
    	Scanner input = new Scanner(rateInput);
    	double rate = input.nextDouble();
    	input.close();
    	
    	String hoursInput = JOptionPane.showInputDialog("How many hours have you worked? (Exclude minutes)");
    	input = new Scanner(hoursInput);
    	double hours = input.nextDouble();
    	input.close();
    	
    	String minutesInput = JOptionPane.showInputDialog("How many minutes have you worked?");
    	input = new Scanner(minutesInput);
    	double minutes = input.nextDouble();
    	input.close();
    	
    	double MINUTES_TO_HOURS = (minutes / 60);
    	double wages = (hours * rate) + (MINUTES_TO_HOURS * rate);
    			
    	JOptionPane.showMessageDialog(null, "You are owed " + '\u20AC' + String.format("%.2f", wages));
    	
    }

}
