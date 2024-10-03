/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 5
       Comment: I used an appropriate constant to replace the number 12 within the code.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 5
       Comment: I used an easy-to-understand, meaningful constant name in the correct format.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 10: 10
       Comment: I used easy-to-understand, meaningful variable names in the correct format.
   4. Did I indent the code appropriately?
       Mark out of 10: 10
       Comment: I indented the code appropriately.
   5. Did I use an appropriate loop (or loops) to produce the different verses?
       Mark out of 20: 20
       Comment: I used appropriate loops to produce the different verses.
   6. Did I use a switch to build up the verses?
       Mark out of 25: 25
       Comment: No, I used a loop instead, as was made optional from brief on Blackboard.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))?
       Mark out of 10: 10
       Comment: Yes, the lines of the song are only written out once within the code.
   8. Does the program produce the correct output?
       Mark out of 10: 10
       Comment: The program produces the correct output.
   9. How well did I complete this self-assessment?
       Mark out of 5: 5
       Comment: I provided a mark and comment for each question.
   Total Mark out of 100 (Add all the previous marks): 100
*/

public class TwelveDaysOfChristmas {
	
	public static final int DAYS_OF_CHRISTMAS = 12;
	
	public static void main(String[] args) {
		
	String outputLyrics = "";
	String day = "";
	
	String[] lyrics = {"partridge in a pear tree.",
			"Two turtle doves",
			"Three French hens,",
			"Four calling birds,",
			"Five golden rings,",
			"Six geese a laying,",
			"Seven swans a swimming,",
			"Eight maids a milking,",
			"Nine ladies dancing,",
			"Ten lords a leaping,",
			"Eleven pipers piping,",
			"Twelve drummers drumming," };
	
	for (int counter = 1; counter <= DAYS_OF_CHRISTMAS; counter++)
	{
		switch (counter)
		{
		case 1:
			day = "first";
			break;
		case 2:
			day = "second";
			break;
		case 3:
			day = "third";
			break;
		case 4:
			day = "fourth";
			break;
		case 5:
			day = "fifth";
			break;
		case 6:
			day = "sixth";
			break;
		case 7:
			day = "seventh";
			break;
		case 8:
			day = "eighth";
			break;
		case 9:
			day = "ninth";
			break;
		case 10:
			day = "tenth";
			break;
		case 11:
			day = "eleventh";
			break;
		case 12:
			day = "twelfth";
			break;
		}
		
		outputLyrics = "On the " + day + " day of Christmas, my true love gave to me:";
		
		for (int lineCounter = counter; lineCounter >= 2; lineCounter-- )
		{
			outputLyrics += "\n" + lyrics[lineCounter-1];
		}
		if (counter == 1)
		{
			outputLyrics += "\n" + "A " + lyrics[0];
		}
		else
		{
			outputLyrics += "\n" + "And a " + lyrics[0];
		}
		System.out.println(outputLyrics + "\n");
	}
	
	}
	
}