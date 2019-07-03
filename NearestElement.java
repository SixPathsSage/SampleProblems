package edu.hiddenleafvillage;

public class NearestElement {

	public static void main(String[] args) {
		int m  = 3, n = 4;
		int[][] b = {
				{0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}
                };
		
		int[][] result = new int[m][n];
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = getNearestOnePosition(b, i, j, m, n);
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}System.out.println();
		}
	}
	
	public static int getNearestOnePosition(int[][] b, int i, int j, int m, int n)
	{
		int globalCount = -1;
		// Fwd check
		int fIndex = j;
		int fwdCount = 0;
		boolean isOneEncountered = false;
		while(fIndex < n)
		{
			if(b[i][fIndex] == 1)
			{
				isOneEncountered = true;
				break;
			}
			else
			{
				fwdCount ++;
			}
			fIndex++;
		}
		if(!isOneEncountered)
		{
			fwdCount = 0;
		}
		
		// Bkd check
		isOneEncountered = false;
		int bIndex = j;
		int bkdCount = 0;
		while(bIndex >= 0)
		{
			if(b[i][bIndex] == 1)
			{
				isOneEncountered = true;
				break;
			}
			else
			{
				bkdCount ++;
			}
			bIndex--;
		}
		if(!isOneEncountered)
		{
			bkdCount = 0;
		}
		globalCount = Integer.max(fwdCount, bkdCount);
		return globalCount;
	}

}
