package edu.hiddenleafvillage;

import java.util.Scanner;

public class ParentLevel {

	public static void main(String[] args) {
		String[][] s = {
				{"Ram", "Syam"},
				{"Akil", "Syam"},
				{"Nikil", "Ram"},
				{"Subhash", "Ram"},
				{"Karthik", "Akil"}
		};
		
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine();
		int op = 0;
		int level = 0;
		String p = "";
		String levelString = "0";
		for (int i = 0; i < in.length(); i++) {
			if(in.charAt(i) != ' ')
			{
				try
				{
					int x = Integer.parseInt(in.charAt(i) +"");
					levelString += in.charAt(i);
				}
				catch (Exception e) {
					p += in.charAt(i);
				}
			}
		}
		
		level = Integer.parseInt(levelString);		
		int m =5, n = 2;
		String[] child = new String[5];
		int index = 0;
		for(int i = 0; i < m; i ++)
		{
			if(s[i][1].equals(p))
			{
				child[index++] = s[i][0];
			}
		}
		
		for(int i = 0; i < m; i ++)
		{
			for (int j = 0; j < child.length; j++) {
				if(s[i][1] == child[j])
				{
					op ++;
				}
			}
		}
		
		System.out.println(op);
		
	}

}
