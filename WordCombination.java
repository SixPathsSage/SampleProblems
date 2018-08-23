package edu.hiddenleafvillage;

import java.util.Scanner;

public class WordCombination {
	private static Scanner in;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		String[] dictionary = {"Sprint", "rint", "Spicy", "print", "pint", "int", "nt", "in", "n", "t"};
		String text = in.next();
		for (int i = 0; i < dictionary.length; i++) {
			String string = matchedWords(dictionary[i], text);
			if(string != "")
			{
				System.out.print(string + ", ");
			}
			
		}
	}
	
	public static String matchedWords(String dw, String s2)
	{
		String output = "";
		for (int i = 0; i < dw.length(); i++) {
			boolean isWordFound = false;
			for (int j = 0; j < s2.length(); j++) {
				if(dw.charAt(i) == s2.charAt(j))
				{
					isWordFound = true;
					break;
				}
			}
			if(isWordFound)
			{
				output += dw.charAt(i);
			}
			else
			{
				return "";
			}
		}
		return output;
	}

}
