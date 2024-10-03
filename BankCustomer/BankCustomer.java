import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class BankCustomer {
	
	private String name;
	private String address;
	private String dateOfBirth;
	private int accountNumber;
	
	public void setName(String customerName)
	{
		name = customerName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setAddress(String customerAddress)
	{
		address = customerAddress;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setDateOfBirth(String customerDateOfBirth)
	{
		dateOfBirth = customerDateOfBirth;
	}
	
	public String getDateOfBirth()
	{
		return dateOfBirth;
	}
	
	public void setAccountNumber(int customerAccountNumber)
	{
		accountNumber = customerAccountNumber;
	}
	
	public int getAccountNumber()
	{
		return accountNumber;
	}
	
	public String findCustomer(BankCustomer[] bankCustomerArray, int customerAccountNumber) {
		String s = "";
		return s;
	}
	
	public String findCustomer(BankCustomer[] bankCustomerArray, String customerDateOfBirth, String customerAddress) {
		String s = "";
		return s;
	}
	
	
	
	public static void main(String args[]) {
    	
		String customerName = "";
		String customerAddress = "";
		String customerDateOfBirth = "";
		int customerAccountNumber = 0;
		String nameOutput = "Names: ";
		String addressOutput = "Addresses: ";
		String dateOfBirthOutput = "Dates of Birth: ";
		String accountNumberOutput = "Account Numbers: ";
		
		ArrayList<String> bankCustomers = new ArrayList<String>();
		
		
    	BankCustomer[] bankCustomerArray = new BankCustomer[5];
    	
    	for (int counter = 0; counter < bankCustomerArray.length; counter++)
    	{
    		customerName = JOptionPane.showInputDialog("Enter the name of customer " + (counter + 1) + ": ");
    		customerAddress = JOptionPane.showInputDialog("Enter the address of customer " + (counter + 1) + ": ");
    		customerDateOfBirth = JOptionPane.showInputDialog("Enter the date of birth of customer " + (counter + 1) + ": ");
        	String accountNumber = JOptionPane.showInputDialog("Enter the account number of customer " + (counter + 1) + ": ");
        	Scanner inputScanner = new Scanner(accountNumber);
    		customerAccountNumber = inputScanner.nextInt();
        	inputScanner.close();
        	bankCustomerArray[counter] = new BankCustomer();
        	bankCustomerArray[counter].setName(customerName);
        	bankCustomerArray[counter].setAddress(customerAddress);
        	bankCustomerArray[counter].setDateOfBirth(customerDateOfBirth);
        	bankCustomerArray[counter].setAccountNumber(customerAccountNumber);
        	
        	bankCustomers.add(bankCustomerArray[counter].getName());
        	bankCustomers.add(bankCustomerArray[counter].getAddress());
        	bankCustomers.add(bankCustomerArray[counter].getDateOfBirth());
        	bankCustomers.add(Integer.toString(bankCustomerArray[counter].getAccountNumber()));
        	
        	/*
        	nameOutput += (bankCustomerArray[counter].getName() + ", ");
        	addressOutput += (bankCustomerArray[counter].getAddress() + ", ");
    		dateOfBirthOutput += (bankCustomerArray[counter].getDateOfBirth() + ", ");
    		accountNumberOutput += (Integer.toString(bankCustomerArray[counter].getAccountNumber()) + ", ");
    		*/
    	}
    	
    	/*
    	nameOutput = nameOutput.substring(0, nameOutput.length() - 2);
    	addressOutput = addressOutput.substring(0, addressOutput.length() - 2);
    	dateOfBirthOutput = dateOfBirthOutput.substring(0, dateOfBirthOutput.length() - 2);
    	accountNumberOutput = accountNumberOutput.substring(0, accountNumberOutput.length() - 2);
    	*/
    	int number = 12345;
    	
    	System.out.println(findCustomer(bankCustomerArray, number));	
    	
    	
    	
		System.out.println(nameOutput);
		System.out.println(addressOutput);
		System.out.println(dateOfBirthOutput);
		System.out.println(accountNumberOutput);
	}
}


