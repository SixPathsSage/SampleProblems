package edu.hiddenleafvillage;

import java.util.Arrays;

public class NQueensII {

	public static void main(String[] args) {
		int[] board = new int[4];
		Arrays.fill(board, -1);
		new NQueensII().placeQueen(board, 0);
	}
	
	public boolean isSafe(int[] board, int position)
	{
		for(int i = 0; i < position; i ++)
		{
			if(board[i] == board[position])
			{
				return false;
			}
			
			if(Math.abs(board[i]-board[position]) == Math.abs(i-position))
			{
				return false;
			}
		}
		return true;
	}
	
	
	public void placeQueen(int[] board, int position)
	{
		if(position >= board.length)
		{
			for(int i = 0; i < board.length; i ++)
			{
				for (int j = 0; j < board.length; j++) {
					if(i == board[j])
					{
						System.out.print("Q" + " ");
					}
					else
					{
						System.out.print("." + " ");
					}
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < board.length; i ++)
		{
			board[position] = i;
			if(isSafe(board, position))
			{
				placeQueen(board, position+1);
			}
			else
			{
				board[position] = -1;
			}
		}
	}

}
