/* SELF ASSESSMENT 
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: Yes, I used the correct method definition.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: Yes, I created an array of size n specified by the user (passed as the parameter) and initialised it.
Did I return the correct item?
Mark out of 5: 5
Comment: Yes, I returned the correct item.
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: Yes, I used the correct method definition.
Did I ensure the parameters are not null and one of them is a valid index into the array?
Mark out of 2: 2
Comment: I ensured the parameters are not null and one of them is a valid index into the array.
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: I looped through the array using the correct multiple i.e. the next non-crossed out number in the sequence.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: Yes, I crossed out correct items in the array that were not already crossed out.
   3.  sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: Yes, I had the correct function definition.
Did I make calls to other methods?
Mark out of 5: 5
Comment: Yes, I made calls to other methods.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 2
Comment: I returned an array with all non-prime numbers are crossed out.
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: Yes, I had the correct function definition.
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: I ensured the parameter to be used is not null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment: Yes, I looped through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets.
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment: Yes, I had the correct function definition.
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: I ensured the parameter to be used is not null.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: Yes, I looped through the array updating the String variable with just the non-crossed out numbers.
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 5
Comments: I asked the user for input n (userInput variable) and handled errors.
Did I make calls to other methods (at least one)?
Mark out of 5: 5
Comment:  I made calls to other methods.
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment: I printed the output as shown in the question.
   7.  Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: Yes, my code is indented correctly.
Do my variable names make sense?
Mark out of 4: 4
Comments: Yes, my variable names make sense.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: Yes, my variable names, method names and class name follow the Java coding standard.
      Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;
public class SieveOfEratosthenes {
	
	public static void main(String[] args) {
		
		int userInput = 0;
		Scanner inputScanner = new Scanner(System.in);
		boolean quit = false;
		while (!quit)
		{
			System.out.println("Enter a positive whole number greater than or equal to 2: ");
			if (!inputScanner.hasNextInt())
			{
				System.out.println("Invalid input. Please try again.");
				inputScanner.next();
			}
			else
			{
				userInput = inputScanner.nextInt();
				if (userInput >= 2)
				{
					quit = true;
				}
			}
		}
		inputScanner.close();
		int[] currentSequence = createSequence(userInput);
		currentSequence = sieve(currentSequence, userInput);
		System.out.println(nonCrossedOutSubseqToString(currentSequence));
	}
	
	public static int[] createSequence(int userInput) {
		
		int[] numberSequence = new int[userInput - 1];
		for (int counter = 0; counter < numberSequence.length; counter++)
		{
			numberSequence[counter] = 0;
		}
		return (numberSequence);
	}
	
	public static int[] sieve(int[] currentSequence, int userInput) {
		
		int currentMultiple = 0;
		boolean quit = false;
		
		for (int counter = 0; (currentMultiple <= (Math.sqrt(userInput))); counter++)
		{
			System.out.println(sequenceToString(currentSequence));
			for (int index = counter; ((index < currentSequence.length) && !quit); index++)
			{
				if (currentSequence[index] == 0)
				{
					currentMultiple = (index + 2);
					counter = index;
					quit = true;
				}
			}
			quit = false;
			crossOutHigherMultiples(currentSequence, currentMultiple);
		}
		return (currentSequence);
	}
	
	public static int[] crossOutHigherMultiples(int[] currentSequence, int currentMultiple) {
		
		int counter = (currentMultiple - 2);
		int placeInArray = counter;
		while (placeInArray < currentSequence.length)
		{
			placeInArray += currentMultiple;
			if (placeInArray < currentSequence.length)
			{
				currentSequence[placeInArray] = 1;
			}
		}
		return (currentSequence);
	}
	
	public static String sequenceToString(int[] currentSequence) {
		
		String currentOutput = "";
		for (int counter = 0; counter < currentSequence.length; counter++)
		{
			if (counter == (currentSequence.length - 1))
			{
				if (currentSequence[counter] == 0)
				{
					currentOutput += (counter + 2);
				}
				else
				{
					currentOutput += ("[" + (counter + 2) + "]");
				}
			}
			else
			{
				if (currentSequence[counter] == 0)
				{
					currentOutput += ((counter + 2) + ", ");
				}
				else
				{
					currentOutput += ("[" + (counter + 2) + "], ");
				}
			}
		}
		return (currentOutput);
	}
	
	public static String nonCrossedOutSubseqToString(int [] currentSequence) {
		
		String finalOutput = "";
		for (int counter = 0; counter < currentSequence.length; counter++)
		{
			if (currentSequence[counter] == 0)
			{
				finalOutput += ((counter + 2) + ", ");
			}
		}
		finalOutput = finalOutput.substring(0, finalOutput.length() - 2);
		return (finalOutput);
	}
	
}
