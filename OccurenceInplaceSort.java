package edu.hiddenleafvillage;

public class OccurenceInplaceSort {

	public static void main(String[] args) {
		int[] n = {2,3,2,5,12,3,2,3,-1};
		int[][] table = new int[n.length][3];
		calculateOccurence(n.length, n, table);
		sortInAscending(n);
		int x = 0;
		for (int i = 0; i < n.length; i++) {
			int[] value = getLargestOccurenceValue(table);
			System.out.println(value[0] + " " + value[1]);
			if(value[1] == 0)
			{
				break;
			}
			x = sortByOccurence(n, value[0], value[1], x);
		}
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + ", ");
		}
	}
	
	public static void sortInAscending(int[] n)
	{
		for (int i = 0; i < n.length; i++) {
			for (int j = i+1; j < n.length; j++) {
				if(n[i] > n[j])
				{
					int t = n[i];
					n[i] = n[j];
					n[j] = t;
				}
			}
		}
	}
	
	public static int sortByOccurence(int[] n, int value, int count, int i)
	{
		int index = 0;
		for (; i < n.length; i++) {
			for (int j = i+1; j < n.length; j++) {
				if(count > 1 && n[i] != value && n[j] == value)
				{
					int t = n[i];
					n[i] = n[j];
					n[j] = t;
					index = i;
				}
			}
		}
		return index+1;
	}
	
	public static int[] getLargestOccurenceValue(int[][] table)
	{
		int value = 0;
		int count = 0;
		int index = 0;
		
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				if(table[i][1] > table[j][1] && table[i][1] > count)
				{
					value = table[i][0];
					count = table[i][1];
					index = i;
				}
				else if(table[i][1] < table[j][1] && table[j][1] > count)
				{
					value = table[j][0];
					count = table[j][1];
					index = j;
				}
				else if(table[i][1] == table[j][1] && table[j][1] > count)
				{
					if(table[i][2] > table[j][2])
					{
						value = table[i][0];
						count = table[i][1];
						index = i;
					}
					else if(table[i][2] < table[j][2])
					{
						value = table[j][0];
						count = table[j][1];
						index = j;
					}
				}
			}
		}
		table[index][1] = -1;
		table[index][2] = -1;
		return new int[] { value, count};
	}
	
	private static void calculateOccurence(int size, int[] array, int[][] table) {
		int index = 0;
		int lastOccurence = -1;
		for (int i = 0; i < size; i++) {
			int count = 0;
			if(!isInArray(array[i], table))
			{
				for (int j = 0; j < size; j++) {
					if(array[i] == array[j])
					{
						lastOccurence = j;
						count ++;
					}
				}
				table[index][0] = array[i];
				table[index][1] = count;
				table[index][2] = lastOccurence;
				index++;
			}
		}
	}
	
	private static boolean isInArray(int number, int[][] table)
	{
		for (int i = 0; i < table.length; i++) {
			if(table[i][0] == number)
			{
				return true;
			}
		}
		return false;
	}

}
