package edu.hiddenleafvillage;

import java.util.Scanner;

public class MiddleOfTheWord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		new MiddleOfTheWord().print(s);
	}
	
	public void print(String s)
	{
		int n = s.length();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (2*n); j++) {
				if(j == (2*n)-2-(i*2))
				{
					for (int k = 0; k <= i; k++) {
						int split = (n/2) + k;
						if(split > n-1)
						{
							split = Math.abs(n-split);
						}
						System.out.print(s.charAt(split));
					}
					break;
				}
				else
				{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
