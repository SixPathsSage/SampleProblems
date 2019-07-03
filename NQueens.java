package edu.hiddenleafvillage;

import java.util.Arrays;

public class NQueens {

	static int[] positionArray = new int[4];
	public static void main(String[] args) {
		Arrays.fill(positionArray, -1);
		placeQueen(0);
	}
	
	public static boolean isSafe(int position)
	{
		for (int i = 0; i < position; i++) {
			if(positionArray[position] == positionArray[i])
			{
				return false;
			}
			
			if(Math.abs(positionArray[i]-positionArray[position]) == Math.abs(i-position))
			{
				return false;
			}
		}
		return true;
	}
	
	public static void placeQueen(int pos)
	{
		if(pos >= 4)
		{
			for (int i = 0; i < positionArray.length; i++) {
				System.out.print(positionArray[i] + " ");
			}
			System.out.println();
			return;
		}
		else
		{
			for (int i = 0; i < positionArray.length; i++) {
				positionArray[pos] = i;
				if(isSafe(pos))
				{
					placeQueen(pos+1);
				}
				else
				{
					positionArray[pos] = -1;
				}
			}
		}
	}
	

}
