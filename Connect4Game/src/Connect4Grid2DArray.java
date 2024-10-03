
public class Connect4Grid2DArray implements Connect4Grid{
	
	private char[][] grid;
	private int lastRow = 0;
	private int lastColumn = 0;
	private char lastColour = 'r';
	final static int ROWS = 6;
	final static int COLUMNS = 7;
	
	public Connect4Grid2DArray() {
		
		grid = new char[ROWS][COLUMNS];
		emptyGrid();
	}
	
	public void emptyGrid() {
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLUMNS; j++)
			{
				grid[i][j] = ' ';
			}	
		}
	}
	
	public String toString() {
		String str = "";
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLUMNS; j++)
			{
				str += "[" + Character.toString(grid[i][j]) + "] ";
			}
			str += "\n";
		}
		return str;
	}
	
	public boolean isValidColumn(int column) {
		boolean valid = false;
		if ((column >= 0) && (column <= 6))
		{
			valid = true;
		}
		return valid;
	}
	
	public boolean isColumnFull(int column) {
		boolean valid = false;
		if ((grid[0][column]) != ('r'|'y'))
		{
			valid = true;
		}
		return valid;
	}
	
	public void dropPiece(ConnectPlayer player, int column) {
		boolean quit = false;
		for (int i = (ROWS-1); ((i >= 0) && (!quit)); i--)
		{
			if ((grid[i][column]) == (' '))
			{
				if (player.isRed() == true)
				{
					grid[i][column] = 'r';
					lastRow = i;
					lastColumn = column;
					lastColour = 'r';
				}
				else
				{
					grid[i][column] = 'y';
					lastRow = i;
					lastColumn = column;
					lastColour = 'y';
				}
				quit = true;
			}
		}
	}
	
	public boolean didLastPieceConnect4() {
		int row = lastRow;
		int column = lastColumn;
		int counter = 0;
		for(int i = 0; i <= (COLUMNS-1); i++)
		{
			if (grid[row][i] == lastColour)
			{
				counter++;
			}
			else
			{
				counter = 0;
			}
			if (counter == 4)
			{
				return true;
			}
		}
		counter = 0;
		for(int i = 0; i <= (ROWS-1); i++)
		{
			if (grid[i][column] == lastColour)
			{
				counter++;
			}
			else
			{
				counter = 0;
			}
			if (counter == 4)
			{
				return true;
			}
		}
		counter = 0;
		while ((row != (ROWS-1)) && (column != 0))
		{
			row++;
			column--;
		}
		while ((row != 0) && (column != (COLUMNS-1)))
		{
			if (grid[row][column] == lastColour)
			{
				counter++;
			}
			else
			{
				counter = 0;
			}
			if (counter == 4)
			{
				return true;
			}
			row--;
			column++;
		}
		counter = 0;
		row = lastRow;
		column = lastColumn;
		while ((row != (ROWS-1)) && (column != (COLUMNS-1)))
		{
			row++;
			column++;
		}
		while ((row != 0) && (column != 0))
		{
			if (grid[row][column] == lastColour)
			{
				counter++;
			}
			else
			{
				counter = 0;
			}
			if (counter == 4)
			{
				return true;
			}
			row--;
			column--;
		}
		return false;
	}
	
	public boolean isGridFull() {
		boolean full = true;
		for(int i = 0; i < ROWS; i++)
		{
			for(int j = 0; j < COLUMNS; j++)
			{
				if ((grid[i][j]) != ('r'|'y'))
				{
					full = false;
				}
			}	
		}
		return full;
	}
}
