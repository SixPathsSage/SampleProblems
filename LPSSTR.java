package com.hiddenleafvillage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LPSSTR {
	//Longest Palindromic Substring
	Map<String, String> mem = new HashMap<>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = "baba";
		System.out.println(new LPSSTR().lps(text));
	}
	
	public String lps(String text)
	{
		if(isPalindrome(text))
		{
			return text;
		}
		
		String ls = "";
		String rs = "";
		if(mem.containsKey(text.substring(0, text.length()-1)))
		{
			ls = mem.get(text.substring(0, text.length()-1));
		}
		else
		{
			ls = lps(text.substring(0, text.length()-1));
		}
		
		if(mem.containsKey(text.substring(0, text.length()-1)))
		{
			rs = mem.get(text.substring(0, text.length()-1));
		}
		else
		{
			rs = lps(text.substring(1, text.length()));
		}
		
		if(ls.length() > rs.length())
		{
			return ls;
		}
		else
		{
			return rs;
		}
	}
	
	public boolean isPalindrome(String text)
	{
		boolean isPalidrome = false;
		if(text.length() == 0 || text.length() == 1)
		{
			return true;
		}
		for (int i = 0; i < text.length()/2; i++) {
			if(text.charAt(i) == text.charAt(text.length()-1))
			{
				isPalidrome = true;
			}
			else
			{
				return false;
			}
		}
		return isPalidrome;
	}

}
