package edu.hiddenleafvillage;

import java.util.Scanner;

public class StringMerge {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		System.out.println("Enter String 1");
		String s1 = in.next();
		System.out.println("Enter String 2");
		String s2 = in.next();
		System.out.println(new StringMerge().getCommonChars(s1, s2));
	}
	
	public String getCommonChars(String s1, String s2)
	{
		String output = "";
		char[] s1Array = toArray(s1);
		
		for(int i = 0; i < s2.length(); i ++)
		{
			for (int j = 0; j < s1.length(); j++) {
				if(s2.charAt(i) == s1.charAt(j))
				{
					output += s2.charAt(i);
					s1Array[j] = '_';
				}
			}
		}
		
		for(int i = 0; i < s1Array.length; i ++)
		{
			if(s1Array[i] != '_')
			{
				output += s1Array[i];
			}
		}
		
		return output;
	}
	
	public char[] toArray(String s)
	{
		char[] array = new char[s.length()];
		for(int i = 0; i < s.length(); i ++)
		{
			array[i] = s.charAt(i);
		}
		return array;
	}

}
