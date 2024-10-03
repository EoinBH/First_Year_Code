import javax.swing.JOptionPane;
import java.util.Scanner;

public class bmi {
    public static void main(String args[]) {
        String weightInput = JOptionPane.showInputDialog("What is your weight (kg)?");
        Scanner inputScanner = new Scanner( weightInput );
        double weight = inputScanner.nextDouble();
        
        String heightInput = JOptionPane.showInputDialog("What is your height (m)?");
        Scanner eoinScanner = new Scanner( heightInput );
        double height = eoinScanner.nextDouble();
        
        double heightsquared = height * height;
        double bmi = weight / heightsquared;
        
        if( bmi < 18.5) {
        JOptionPane.showMessageDialog(null, "Your Body Mass Index = " + bmi + " which indicates that you may be underweight");
        } else if(bmi <= 24.9&& bmi >= 18.5) {
        JOptionPane.showMessageDialog(null, "Your Body Mass Index = " + bmi + " which indicates that your weight is ideal");
        } else if(bmi <= 29.9 && bmi >= 25) {
        JOptionPane.showMessageDialog(null, "Your Body Mass Index = " + bmi + " which indicates that you may be overweight");
        } else {
        JOptionPane.showMessageDialog(null, "Your Body Mass Index = " + bmi + " which indicates that you may be obese");
        }
        
      
      System.out.println("Your Body Mass Index = " + bmi);
      
      inputScanner.close();
      eoinScanner.close();
    }
}