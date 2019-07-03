package com.hiddenleafvillage;

public class GenerateParanthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GenerateParanthesis().printParanthesis(3, 0, 0, 0, new char[6]);
	}
	
	public void printParanthesis(int n, int open, int close, int position, char[] text)
	{
		if(close == n)
		{
			for (int i = 0; i < text.length; i++) {
				System.out.print(text[i]);
			}
			System.out.println();
		}
		else
		{
			if(open > close)
			{
				text[position] = ')';
				printParanthesis(n, open, close+1, position+1, text);
			}
			if(open < n)
			{
				text[position] = '(';
				printParanthesis(n, open+1, close, position+1, text);
			}
		}
	}

}
