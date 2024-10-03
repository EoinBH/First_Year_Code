/* SELF ASSESSMENT 

1. readDictionary
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition.
- My method reads the words from the "words.txt" file. [Mark out of 5: 5]
- Comment: Yes, my method reads the words from the "words.txt" file.
- It returns the contents from "words.txt" in a String array or an ArrayList. [Mark out of 5: 5]
- Comment: Yes, it returns the contents from "words.txt" in an ArrayList of String references.

2. readWordList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition.
- My method reads the words provided (which are separated by commas), saves them to an array or ArrayList of String references and returns it. [Mark out of 5: 5]
- Comment: Yes, my method reads the comma-separated words and saves them to an ArrayList of String references and returns it.

3. isUniqueList
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition.
- My method compares each word in the array with the rest of the words in the list. [Mark out of 5: 5]
- Comment: Yes, my method compares each word in the array with the rest of the words in the list.
- Exits the loop when a non-unique word is found. [Mark out of 5: 5]
- Comment: Yes, it exits the loop when a non-unique word is found.
- Returns true if all the words are unique and false otherwise. [Mark out of 5: 5]
- Comment: Yes, it returns true if all the words are unique and false otherwise.

4. isEnglishWord
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition.
- My method uses the binarySearch method in Arrays library class. [Mark out of 3: 3]
- Comment: Yes, my method uses the binarySearch method in Arrays library class.
- Returns true if the binarySearch method return a value >= 0, otherwise false is returned. [Mark out of 2: 2]
- Comment: Yes, it returns true if the binarySearch method return a value >= 0, otherwise false is returned.

5. isDifferentByOne
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition.
- My method loops through the length of the words comparing characters at the same position in both words searching for one difference. [Mark out of 10: 10]
- Comment: Yes, my method loops through the length of the words comparing characters at the same position in both words searching for one difference.

6. isWordChain
- I have the correct method definition [Mark out of 5: 5]
- Comment: Yes, I have the correct method definition.
- My method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message [Mark out of 10: 10]
- Comment: Yes, my method calls isUniqueList, isEnglishWord and isDifferentByOne methods and prints the appropriate message.

7. main
- Reads all the words from file words.txt into an array or an ArrayList using any of the Java.IO classes covered in lectures [Mark out of 10: 10]
- Comment: Yes, my main method calls the readDictionary method which reads all the words from file words.txt into an ArrayList.
- Asks the user for input and calls isWordChain [Mark out of 5: 5]
- Comment: Yes, it calls the readWordList method which asks the user for input, then it calls isWordChain.

 Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordLinksPuzzleGame {
	
	public static final ArrayList<String> LIST = new ArrayList<String>();
	public static Scanner inputScanner = new Scanner(System.in);
	
	public static ArrayList<String> readDictionary() throws FileNotFoundException {
		
		File words = new File("/Users/eoinwbh/eclipse-workspace/WordLinksPuzzleGame/src/words.txt");
		Scanner scanner = new Scanner(words);
		while (scanner.hasNextLine())
		{
			String nextString = scanner.nextLine();
			LIST.add(nextString);
		}
		scanner.close();
		return LIST;
	}
	
	
	public static ArrayList<String> readWordList() {
		String inputString = "";
		ArrayList<String> userInput = new ArrayList<String>();
		System.out.println("Enter a comma separated list of words (or an empty list to quit): ");
		if (inputScanner.hasNextLine())
		{
			inputString = inputScanner.nextLine();
		}
		Scanner strScanner = new Scanner(inputString);
		strScanner.useDelimiter(", *|\n");
		while (strScanner.hasNext())
		{		
			userInput.add(strScanner.next());
		}
		strScanner.close();
		return userInput;
	}
	
	
	public static boolean isUniqueList(ArrayList<String> userInput) {
		boolean isUniqueList = true;
		for (int i1 = 0; i1 < (userInput.size() - 1); i1++)
		{
			String currentString = userInput.get(i1);
			for (int i2 = (i1 + 1); i2 < userInput.size(); i2++)
			{
				String nextString = userInput.get(i2);
				if (currentString == nextString)
				{
					isUniqueList = false;
				}
			}
		}
		return isUniqueList;
	}
	
	
	public static boolean isEnglishWord(String currentString) {
		boolean isEnglishWord = true;
		if (Collections.binarySearch(LIST, currentString) < 0)
		{
			isEnglishWord = false;
		}
		return isEnglishWord;
	}
	
	
	public static boolean isDifferentByOne(String currentString, String nextString) {
		boolean isDifferentByOne = false;
		int counter = 0;
		if (currentString.length() == nextString.length())
		{
			for (int i = 0; i < currentString.length(); i++)
			{
				char currentChar = currentString.charAt(i);
				char nextChar = nextString.charAt(i);
				if (currentChar != nextChar)
				{
					counter++;
				}
			}
		}
		if (counter == 1)
		{
			isDifferentByOne = true;
		}
		return isDifferentByOne;
	}
	
	
	public static boolean isWordChain(ArrayList<String> userInput) {
		boolean isWordChain = false;
		int allEnglish = 0;
		boolean quit = false;
		if ((isUniqueList(userInput)) == true)
		{
			for (int counter = 0; counter < userInput.size(); counter++)
			{
				String currentString = userInput.get(counter);
				if (isEnglishWord(currentString) == true)
				{
					allEnglish++;
				}
			}
			if (allEnglish == userInput.size())
			{
				for (int i = 0; (i < (userInput.size() - 1)) && !quit; i++)
				{
					if (isDifferentByOne(userInput.get(i), userInput.get(i + 1)) == false)
					{
						quit = true;
					}
				}
				if (quit == false)
				{
					isWordChain = true;
				}
			}
		}
		return isWordChain;
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		boolean end = false;
		readDictionary();
		while (end == false)
		{
			ArrayList<String> userInput = readWordList();
			if (userInput.size() != 0)
			{
				if (isWordChain(userInput) == true)
				{
					System.out.println("Valid chain of words from Lewis Carroll's word-links game." + "\n");
				}
				else
				{
					System.out.println("Not a valid chain of words from Lewis Carroll's word-links game." + "\n");
				}
			}
			else
			{
				end = true;
			}
		}
	}

}
