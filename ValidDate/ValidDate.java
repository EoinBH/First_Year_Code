import java.util.Scanner;
public class ValidDate {
	
	public static final int FEBRUARY = 2;
	public static final int APRIL = 4;
	public static final int JUNE = 6;
	public static final int SEPTEMBER = 9;
	public static final int NOVEMBER = 11;
	
	public static void main(String args[])
	{
		Scanner inputScanner = new Scanner(System.in);
		
		System.out.println("Input the day (number from 1 to 31): ");
		int day = inputScanner.nextInt();
		
		System.out.println("Input the month (number from 1 to 12): ");
		int month = inputScanner.nextInt();
		
		System.out.println("Input the year: ");
		int year = inputScanner.nextInt();
		
		if (validDate(year, month, day))
		{
			System.out.println("This is a valid date.");
		}
		else
		{
			System.out.println("This is not a valid date.");
		}
		inputScanner.close();
	}
	
	
	
	public static boolean validDate(int year, int month, int day)
	{
		return ((day > 0) && (day <= daysInMonth(month, year)));
	}
	
	

	public static int daysInMonth(int month, int year)
	{
		if ((month == SEPTEMBER) || (month == APRIL) || (month == JUNE) || (month == NOVEMBER))
		{
			return (30);
		}
		else if (month == FEBRUARY)
		{
			if (isLeapYear(year))
			{
				return (29);
			}
			else
			{
				return (28);
			}
		}
		else
		{
			return (31);
		}
	}
	
	
	
	public static boolean isLeapYear(int year)
	{
		return ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)));
	}

}

