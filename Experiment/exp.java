import javax.swing.JOptionPane;
import java.util.Scanner;

public class exp {
	public static void main(String args[]) {
		String numberInput = JOptionPane.showInputDialog("Type a number to be encrypted.");
		Scanner numberScanner = new Scanner( numberInput );
		double number = numberScanner.nextDouble();
		
		
		if (number <= 18 && number >=1) {
		double encryp = number + (number / 2);
		System.out.println("Your encryption is " + encryp);
		} else if (number <= 26 && number >= 18) {
			double encryp = number - (number / 2);
			System.out.println("Your encryption is " + encryp);
		} else {
			System.out.println("You have failed.");
			
		}
		if (encryp = 7.5) {
			String alpha = "a";
			
			}
		
		numberScanner.close();
	}
		
		
	}
	


	