package edu.hiddenleafvillage;

public class MatrixRotation {

	public static void main(String[] args) {
		int[][] a = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		System.out.println("Actual Array");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		MatrixRotation mr = new MatrixRotation();
		a = mr.rotateMatrix(a, 3, 4);
		System.out.println();
		System.out.println("Rotated Array");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] rotateMatrix(int[][] a, int m, int n)
	{
		int row = 0; int col = 0;
		
		while(row < m && col < n)
		{
			int temp = a[row+1][col];
			int temp1 = 0;
			for(int i = col; i < n; i ++)
			{
				temp1 = a[row][i];
				a[row][i] = temp;
				temp = temp1;
			}
			row ++;
			
			for(int i = row; i < m; i ++)
			{
				temp1 = a[i][n-1];
				a[i][n-1] = temp;
				temp = temp1;
			}
			n--;
			
			if(col < n)
			{
				for(int i = n-1; i >= col; i --)
				{
					temp1 = a[m-1][i];
					a[m-1][i] = temp;
					temp = temp1;
				}
			}
			m--;
			
			if(row < m)
			{
				for(int i = m-1; i >= row; i--)
				{
					temp1 = a[i][col];
					a[i][col] = temp;
					temp = temp1;
				}
			}
			col ++;
		}
		
		return a;
	}

}
