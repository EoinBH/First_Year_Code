import javax.swing.JOptionPane;
public class VernamCipher {
	
	private static String key = "king";
	
	public static void set(String newKey) {
		
		key = newKey;
	}
	
	public static void get() {
		
		System.out.println("Key is: " + key);
		System.out.println("Length of key is: " + key.length());
	}
	
	public static void main(String[] args) {
		
		String key = JOptionPane.showInputDialog("Enter a new key for encryption: ");
		VernamCipher.set(key);
		String plaintext = JOptionPane.showInputDialog("Enter your text to be encrypted: ");
		
		VernamCipher.get();
		System.out.println("Plaintext is: " + plaintext);
		System.out.println("Length of plaintext is: " + plaintext.length());
		
		if (VernamCipher.key.length() > plaintext.length())
		{
			//reduce key by difference between key and plain text
			String newKey = "";
			String nextChar = "";
			int keyLength = (plaintext.length());
			for (int i = 0; i < keyLength; i++)
			{
				nextChar = Character.toString(VernamCipher.key.charAt(i));
				newKey += nextChar;
			}
			VernamCipher.set(newKey);
		}
		else if (VernamCipher.key.length() < plaintext.length())
		{
			//increase key by difference between key and plain text, (using repetition of key)
			String newKey = "";
			String nextChar = "";
			boolean quit = false;
			int keyLength = (plaintext.length());
			while (!quit)
			{
				for (int i = 0; (i < VernamCipher.key.length()) && (newKey.length() < keyLength); i++)
				{
					nextChar = Character.toString(VernamCipher.key.charAt(i));
					newKey += nextChar;
				}
				if (newKey.length() == keyLength)
				{
					quit = true;
				}
			}
			VernamCipher.set(newKey);
		}
		
		VernamCipher.get();
		System.out.println("Plaintext is: " + plaintext);
		System.out.println("Length of plaintext is: " + plaintext.length());
		
		//now that key and plain text are the same length, XOR these two strings
		
		
	}

}
