package edu.hiddenleafvillage;

public class NextHighest {

	public static void main(String[] args) {
		int[] array = {40,50,11,32,55,75,75};
		int[] nh = nextHighest(array);
		
		for (int i = 0; i < nh.length; i++) {
			System.out.print(nh[i] + " ");
		}
		System.out.println();
		
	}
	
	
	public static int[] nextHighest(int[] array)
	{
		int[] nextHighest = new int[array.length];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			int localHighest = Integer.MAX_VALUE;
			for (int j = i+1; j < array.length; j++) {
				if(array[i] < array[j] && array[j] < localHighest)
				{
					localHighest = array[j];
				}
			}
			if(localHighest < Integer.MAX_VALUE)
			{
				nextHighest[index++] = localHighest;
			}
			else
			{
				nextHighest[index++] = -1;
			}
		}
		return nextHighest;
	}

}
