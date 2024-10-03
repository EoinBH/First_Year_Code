import java.util.Random;
public class C4RandomAIPlayer extends ConnectPlayer {

	public C4RandomAIPlayer(int colour) {
		setColour(colour);
	}
	
	@Override
	public int selectColumn() {
		
		Random random = new Random();
		int column = random.nextInt(7);
		System.out.println(column+1);
		return column;
	}
}
