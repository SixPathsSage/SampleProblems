package edu.hiddenleafvillage;

import java.util.Arrays;

public class KnightTraversal {

	int[][] moves = {{1,2}, {-1,2}, {1,-2} , {-1,-2}, {2,1}, {-2,1}, {2, -1}, {-2,-1}};
	int maxMoves = 16;
	public static void main(String[] args) {
		KnightTraversal kt = new KnightTraversal();
		int[][] boards = new int[4][4];
		boards = kt.initiaizeArray(boards, -1);
		kt.placeKnight(boards, 0, 0, 1);
		
	}
	
	public int[][] initiaizeArray(int[][] a, int initialVaue)
	{
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = initialVaue;
			}
		}
		return a;
	}
	
	public boolean isSafe(int[][] board, int row, int col)
	{
		return (row >= 0 && row < board.length && col >= 0 && col < board.length && board[row][col] == -1);
	}
	
	public boolean placeKnight(int[][] board, int row, int col, int move)
	{
		if(move >= maxMoves)
		{
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					System.out.print(board[i][i] + " ");
				}
				System.out.println();
			}
			return true;
		}
		
		for (int i = 0; i < moves.length; i++) {
			int nextRow = row + moves[i][0];
			int nextColumn = col + moves[i][1];
			if(isSafe(board, nextRow, nextColumn))
			{
				board[nextRow][nextColumn] = move;
				if(placeKnight(board, nextRow, nextColumn, move+1))
				{
					return true;
				}
				else
				{
					board[nextRow][nextColumn] = -1;
				}
			}
		}
		return false;
	}

}
