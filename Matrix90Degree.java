package edu.hiddenleafvillage;

public class Matrix90Degree {

	public static void main(String[] args) {
		int[][] a = {
				 {1,  2,  3, 4}, 
				 {5,  6,  7,  8}, 
				 {9, 10, 11, 12}, 
				 {13, 14, 15, 16}
				 };
		rotate(a, 4, 4);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void rotate(int[][] a, int m, int n)
	{
		for(int i = 0; i < n/2; i ++)
		{
			for (int j = i; j < n-1-i; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][n-1-i];
				a[j][n-1-i] = a[n-1-i][n-1-j];
				a[n-1-i][n-1-j] = a[n-1-j][i];
				a[n-1-j][i] = temp;
			}
		}
	}

}
