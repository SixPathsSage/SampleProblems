package com.hiddenleafvillage;

import java.util.Scanner;

public class LSSWR {
	//Longest Substring without repeating characters
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.next();
//		String text = "abcabcbb";
		LSSWR l = new LSSWR();
		System.out.println(l.lengthOfSubstring(text));
	}
	
	public int lengthOfSubstring(String text)
	{
		int length = 0;
		String result = "";
		for (int i = 0; i < text.length(); i++) {
			String temp = text.charAt(i) + "";
			boolean contains = false;
			for(int j = 0; j < result.length(); j ++)
			{
				if(result.charAt(j) == text.charAt(i))
				{
					contains = true;
				}
			}
			if(!contains)
			{
				result += temp;
			}
			else if(length < result.length())
			{
				length = result.length();
				result = temp;
			}
		}
		return length;
	}
}
