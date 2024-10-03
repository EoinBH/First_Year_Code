import java.util.Arrays;
public class QueenProblem {
	
	public static int LENGTH = 8;
	
	public static void main(String[] args)
	{
		boolean quit = false;
		
		int[] row1 = new int[LENGTH];
		int[] row2 = new int[LENGTH];
		int[] row3 = new int[LENGTH];
		int[] row4 = new int[LENGTH];
		int[] row5 = new int[LENGTH];
		int[] row6 = new int[LENGTH];
		int[] row7 = new int[LENGTH];
		int[] row8 = new int[LENGTH];
		
		
		
		while (!quit)
		{
			int counter = 5;
			int rowCounter = 6;
			row1[counter] = 1;
			
			//RIGHT
			for (int i = counter+1; i < LENGTH; i++)
			{
				row1[i] = 9;
			}
			
			//LEFT
			for (int i = counter-1; i > -1; i--)
			{
				row1[i] = 9;
			} 
			
			//UP & DOWN
			switch (rowCounter)
			{
			case 1:	
				row2[counter] = 9;
				row3[counter] = 9;
				row4[counter] = 9;
				row5[counter] = 9;
				row6[counter] = 9;
				row7[counter] = 9;
				row8[counter] = 9;
				break;
			case 2:
				row1[counter] = 9;
				row3[counter] = 9;
				row4[counter] = 9;
				row5[counter] = 9;
				row6[counter] = 9;
				row7[counter] = 9;
				row8[counter] = 9;
				break;
			case 3:
				row1[counter] = 9;
				row2[counter] = 9;
				row4[counter] = 9;
				row5[counter] = 9;
				row6[counter] = 9;
				row7[counter] = 9;
				row8[counter] = 9;
				break;
			case 4:
				row1[counter] = 9;
				row2[counter] = 9;
				row3[counter] = 9;
				row5[counter] = 9;
				row6[counter] = 9;
				row7[counter] = 9;
				row8[counter] = 9;
				break;
			case 5:
				row1[counter] = 9;
				row2[counter] = 9;
				row3[counter] = 9;
				row4[counter] = 9;
				row6[counter] = 9;
				row7[counter] = 9;
				row8[counter] = 9;
				break;
			case 6:
				row1[counter] = 9;
				row2[counter] = 9;
				row3[counter] = 9;
				row4[counter] = 9;
				row5[counter] = 9;
				row7[counter] = 9;
				row8[counter] = 9;
				break;
			case 7:
				row1[counter] = 9;
				row2[counter] = 9;
				row3[counter] = 9;
				row4[counter] = 9;
				row5[counter] = 9;
				row6[counter] = 9;
				row8[counter] = 9;
				break;
			case 8:
				row1[counter] = 9;
				row2[counter] = 9;
				row3[counter] = 9;
				row4[counter] = 9;
				row5[counter] = 9;
				row6[counter] = 9;
				row7[counter] = 9;
				break;
				
			}
			
			
			quit = true;
		}
		
		System.out.println(Arrays.toString(row1) + "\n" + Arrays.toString(row2) + "\n" + 
				Arrays.toString(row3) + "\n" + Arrays.toString(row4) + "\n" +
				Arrays.toString(row5) + "\n" + Arrays.toString(row6) + "\n" +
				Arrays.toString(row7) + "\n" + Arrays.toString(row8));
	
	}

}
