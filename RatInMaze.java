package edu.hiddenleafvillage;

import java.util.HashMap;
import java.util.Map;

public class RatInMaze {

	static int[][] maze = {
			{1, 1, 1, 1},
            {1, 0, 1, 1},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
		};
	
	static int m = 4, n = 4;
	static int count = 0;
	static int dx = m-1;
	static int dy = n-1;
	
	static Map<String, Boolean> memory = new HashMap<>();
	
	public static void main(String[] args) {
		if(find(0, 0, 0, 0))
		{
			System.out.println("Can reach destination in " + count + " way(s)");
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
			}
			
//			Set set = memory.entrySet();
//			Iterator i = set.iterator();
//			while(i.hasNext())
//			{
//				Map.Entry mentry = (Map.Entry)i.next();
//		        System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
//		        System.out.println(mentry.getValue());
//			}
//			
		}
		else
		{
			System.out.println("No way for the rat");
		}
		
		
	}
	
	public static boolean find(int x, int y, int i, int j)
	{
		if(maze[x][y] == 0)
		{
			return false;
		}
		if(x == dx && y == dy)
		{
			count ++;
			return true;
		}
		
		boolean left = false;
		boolean right = false;
//		boolean up = false;
		boolean down = false;
		
		if(memory.get("(" + x + ", " + (y+1) + ")") != null)
		{
			right = memory.get("(" + x + ", " + (y+1) + ")");
		}
		else
		{
			if(!(x == i && y+1 == j) && isFeasible(x, y+1))
			{
				right =  find(x, y+1, x, y);
			}
		}
		
		if(memory.get("(" + x + ", " + (y-1) + ")") != null)
		{
			left = memory.get("(" + x + ", " + (y-1) + ")");
			System.out.println("Taking from memory for left");
		}
		else
		{
			if(!(x == i && y-1 == j) && isFeasible(x, y-1))
			{
				left = find(x, y-1, x, y);
				memory.put("(" + x + ", " + (y-1) + ")", left);
			}
		}
		
//		if(memory.get("(" + (x-1) + ", " + y + ")") != null)
//		{
//			up = memory.get("(" + (x-1) + ", " + y + ")");
//			System.out.println("Taking from memory for up");
//		}
//		else
//		{
//			if(!(x-1 == i && y == j) && isFeasible(x-1, y))
//			{
//				up = find(x-1, y, x, y);
//				memory.put("(" + (x-1) + ", " + y + ")", up);
//			}
//		}
		
		if(memory.get("(" + (x+1) + ", " + y + ")") != null)
		{
			down = memory.get("(" + (x+1) + ", " + y + ")");
		}
		else
		{
			if(!(x+1 == i && y == j) && isFeasible(x+1, y))
			{
				down = find(x+1, y, x, y);
			}
		}
		
		boolean result = left || right || down;
		memory.put("(" + x + ", " + y + ")", result);
		if(!result)
		{
			maze[x][y] = 0;
		}
		
		return result;
	}
	
	public static boolean isFeasible(int x, int y)
	{
		return x >=0 && x < m && y >= 0 && y < n;
	}
	

}
