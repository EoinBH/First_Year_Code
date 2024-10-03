import javax.swing.JOptionPane;

public class VertebrateClass {
	public static void main(String args[]) {
		
		int habitablePlanetanswer = JOptionPane.showConfirmDialog(null, "Is the planet habitable?");
		boolean habitablePlanet = (habitablePlanetanswer == JOptionPane.YES_OPTION);
		if (habitablePlanet == false)
		{
			JOptionPane.showMessageDialog(null, "There is no vertebrate");
		}
		else
		{
			int finsAnswer = JOptionPane.showConfirmDialog(null, "Does the vertebrate have fins?");
			boolean fins = (finsAnswer == JOptionPane.YES_OPTION);
			if (fins == true)
			{
				JOptionPane.showMessageDialog(null, "The vertebrate class is FISH");
			}
			else
			{
				int scalesAnswer = JOptionPane.showConfirmDialog(null, "Does the vertebrate have scales?");
				boolean scales = (scalesAnswer == JOptionPane.YES_OPTION);
				if (scales == true)
				{
					JOptionPane.showMessageDialog(null, "The vertebrate class is REPTILE");
				}
				else
				{
					int coldBloodAnswer = JOptionPane.showConfirmDialog(null, "Is your vertebrate cold-blooded?");
					boolean coldBlood = (coldBloodAnswer == JOptionPane.YES_OPTION);
					if (coldBlood == true)
					{
						JOptionPane.showMessageDialog(null, "The vertebrate class is Amphibian");
					}
					else
					{
						int feathersAnswer = JOptionPane.showConfirmDialog(null, "Does the vertebrate have feathers?");
						boolean feathers = (feathersAnswer == JOptionPane.YES_OPTION);
						if (feathers == true)
						{
							JOptionPane.showMessageDialog(null, "The vertebrate class is BIRD");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "The vertebrate class is MAMMAL");
						}
					}
				}
			}
		}	
	}
	
}