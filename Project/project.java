import java.util.Scanner;

import javax.swing.JOptionPane;

public class project {
		public static void main(String args[]) {
		final char DOT = '\u0307';
		final char TILDE = '\u0303';
		
		char excl = '\u0021';
		
		//diaeresis//
		char adia = '\u00E4';
		char edia = '\u00EB';
		char idia = '\u00EF';
		char odia = '\u00F6';
		char udia = '\u00FC';
		char adiaC = '\u00C4';
		char ediaC = '\u00CB';
		char idiaC = '\u00CF';
		char odiaC = '\u00D6';
		char udiaC = '\u00DC';
		
		//tilde//
		char atil = '\u00E3';
		char etil = '\u1EBD';
		char itil = '\u0129';
		char otil = '\u00F5';
		char util = '\u0169';
		char atilC = '\u00C3';
		char etilC = '\u1EBC';
		char itilC = '\u0128';
		char otilC = '\u00D5';
		char utilC = '\u0168';
		
		//accent 1//
		char aac1 = '\u00E1';
		char eac1 = '\u00E9';
		char iac1 = '\u00ED';
		char oac1 = '\u00F3';
		char uac1 = '\u00FA';
		char aac1C = '\u00C1';
		char eac1C = '\u00C9';
		char iac1C = '\u00CD';
		char oac1C = '\u00D3';
		char uac1C = '\u00DA';
		
		//accent 2//
		char aac2 = '\u00E0';
		char eac2 = '\u00E8';
		char iac2 = '\u00EC';
		char oac2 = '\u00F2';
		char uac2 = '\u00F9';
		char aac2C = '\u00C0';
		char eac2C = '\u00C8';
		char iac2C = '\u00CC';
		char oac2C = '\u00D2';
		char uac2C = '\u00D9';
		
		//dot//
		char adot = '\u0227';
		char edot = '\u0117';
		char idot = '\u00EE';
		char odot = '\u022F';
		char adotC = '\u0226';
		char edotC = '\u0116';
		char idotC = '\u00CE';
		char odotC = '\u022E';
		
		//b//
		char bdot = '\u1E03';
		char bdotC = '\u1E02';
		
		//c//
		char cdot = '\u010B';
		char cdotC = '\u010A';
		
		//d//
		char ddot = '\u1E0B';
		char ddotC = '\u1E0A';
		
		//g//
		char gdot = '\u0121';
		char gdotC = '\u0120';
		
		//v//
		
		//z//
		char zdot = '\u017C';
		char zdotC = '\u017B';
		
		//tilde (consonants)//
		
		String sentenceInput = JOptionPane.showInputDialog("Input a sentence");
    	Scanner sentenceScanner = new Scanner(sentenceInput);
    	String sentence = sentenceScanner.nextLine();
    	sentenceScanner.close();
    	
    	JOptionPane.showMessageDialog(null, "Your sentence is " + sentence);
		
		System.out.println('\u8CC4' + "" + '\u8CC2');
		
		}
		
		
	}