
public abstract class ConnectPlayer {
	
	private int colour = 0;
	public abstract int selectColumn();
	
	public boolean isRed() {
		if (this.colour == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void setColour(int colour) {
		this.colour = colour;
	}
}
