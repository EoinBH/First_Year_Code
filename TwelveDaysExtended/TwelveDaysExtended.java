/* SELF ASSESSMENT
 1. Did I use easy-to-understand meaningful, properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment: I used meaningful, easily understood and correctly formatted variable names and constants.
 2. Did I implement the getVerse function correctly and in a manner that can be understood
 	(5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment: I implemented the getVerse function correctly and in an easily-understood manner.
 3. Did I implement the getChristmasGift function correctly using a switch statement and in a manner that can be understood
 	(5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment: I implemented the getChristmasGift function correctly using a switch statement and in an easily-understood manner.
 4. Did I implement the getOrdinalString function correctly using if or conditional operators and in a manner that can be understood
 	(5 marks for function definition, 5 marks for function call and 15 marks for function implementation)?
       Mark out of 25: 25
        Comment: I implemented the getOrdinalString function correctly using if-else statements and in an easily-understood manner.
 5. Does the program produce the output correctly?
       Mark out of 10: 10
        Comment: The program produces the correct output and includes a space between each verse so that the lyrics can be read clearly.
 6. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment: I provided a mark and comment for every question.
 Total Mark out of 100 (Add all the previous marks): 100
*/ 
public class TwelveDaysExtended {
	
	public static final int DAYS_OF_CHRISTMAS = 12;
	
	public static void main(String[] args) {
		
		int verseCounter = 1;
		while (verseCounter <= DAYS_OF_CHRISTMAS)
		{
			System.out.println(getVerse(verseCounter));
			verseCounter++;
		}
	}
	
	
	public static String getVerse(int verseCounter)
	{
		int dayCounter = verseCounter;
		int lineCounter = verseCounter;
		String verse = "On the " + getOrdinalString(dayCounter) + " day of Christmas, my true love gave to me:";
		int lineCounterSaver = lineCounter;
		while (lineCounter >= 2)
		{
			verse += "\n" + getChristmasGift(lineCounter);
			lineCounter--;
		}
		lineCounter = lineCounterSaver;
		if (lineCounter == 1)
		{
			verse += "\n" + "A " + getChristmasGift(lineCounter);
		}
		else
		{
			lineCounter = 1;
			verse += "\n" + "And a " + getChristmasGift(lineCounter);
		}
		return (verse + "\n");
	}
	
	
	public static String getOrdinalString(int dayCounter)
	{
		String ordinalString = "";
		if (dayCounter == 1)
		{
			ordinalString = "first";
		}
		else if (dayCounter == 2)
		{
			ordinalString = "second";
		}
		else if (dayCounter == 3)
		{
			ordinalString = "third";
		}
		else if (dayCounter == 4)
		{
			ordinalString = "fourth";
		}
		else if (dayCounter == 5)
		{
			ordinalString = "fifth";
		}
		else if (dayCounter == 6)
		{
			ordinalString = "sixth";
		}
		else if (dayCounter == 7)
		{
			ordinalString = "seventh";
		}
		else if (dayCounter == 8)
		{
			ordinalString = "eighth";
		}
		else if (dayCounter == 9)
		{
			ordinalString = "ninth";
		}
		else if (dayCounter == 10)
		{
			ordinalString = "tenth";
		}
		else if (dayCounter == 11)
		{
			ordinalString = "eleventh";
		}
		else if (dayCounter == 12)
		{
			ordinalString = "twelfth";
		}
		return (ordinalString);
	}
	
	
	public static String getChristmasGift(int lineCounter)
	{
		String christmasGift = "";
		switch (lineCounter)
		{
		case 1:
			christmasGift = "partridge in a pear tree.";
			break;
		case 2:
			christmasGift = "Two turtle doves,";
			break;
		case 3:
			christmasGift = "Three French hens,";
			break;
		case 4:
			christmasGift = "Four calling birds,";
			break;
		case 5:
			christmasGift = "Five golden rings,";
			break;
		case 6:
			christmasGift = "Six geese a laying,";
			break;
		case 7:
			christmasGift = "Seven swans a swimming,";
			break;
		case 8:
			christmasGift = "Eight maids a milking,";
			break;
		case 9:
			christmasGift = "Nine ladies dancing,";
			break;
		case 10:
			christmasGift = "Ten lords a leaping,";
			break;
		case 11:
			christmasGift = "Eleven pipers piping,";
			break;
		case 12:
			christmasGift = "Twelve drummers drumming,";
			break;
		}
		return (christmasGift);
	}
}

