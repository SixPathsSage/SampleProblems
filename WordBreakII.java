package edu.hiddenleafvillage;

import java.util.Scanner;

public class WordBreakII {

	static String[] dictionary = {"I", "like", "apple", "samsung", "hate", "pine", "am", "forest", "great"};
	private static Scanner in;
	public static void main(String[] args) {
		in = new Scanner(System.in);
		String text = in.next();
		breakWords(text, "");
		// TODO Auto-generated method stub
		
	}
	
	public static void breakWords(String text, String output)
	{
		if(text.length() == 0 || text.length() == 1)
		{
			return;
		}
		
		for (int i = 1; i <= text.length(); i++) {
			String prefixWord = text.substring(0, i);
			if(isWordInDictionary(prefixWord))
			{
				if(i == text.length())
				{
					System.out.println(output + " " + prefixWord);
					return;
				}
				breakWords(text.substring(i, text.length()), output + " " + prefixWord);
			}
		}
	}
	
	public static boolean isWordInDictionary(String word)
	{
		for (int i = 0; i < dictionary.length; i++) {
			if(dictionary[i].equalsIgnoreCase(word))
			{
				return true;
			}
		}
		return false;
	}

}
