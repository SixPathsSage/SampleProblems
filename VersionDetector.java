package edu.hiddenleafvillage;

public class VersionDetector {

	public static void main(String[] args) {
		String v1 = "10.001.01.101";
		String v2 = "10.001.1.10";
		
		double[] version1 = toArray(getArraysize(v1), v1);
		double[] version2 = toArray(getArraysize(v2), v2);
		
		int x = 0;
		int y = 0;
		while(x < version1.length && y < version2.length)
		{
			if(version1[x] > version2[y])
			{
				System.out.println(v1 + " is Greater");
				return;
			}
			else if(version1[x] < version2[y])
			{
				System.out.println(v2 + " is Greater");
				return;
			}
			else
			{
				x++;
				y++;
			}
		}
		
		if(x < version1.length && y >= version2.length)
		{
			while(x < version1.length)
			{
				if(version1[x] > 0.0)
				{
					System.out.println(v1 + " is Greater");
					return;
				}
				else
				{
					x++;
				}
			}
		}
		
		else if(x >= version1.length && y < version2.length)
		{
			while(y < version2.length)
			{
				if(version2[y] > 0.0)
				{
					System.out.println(v2 + " is Greater");
					return;
				}
				else
				{
					y++;
				}
			}
		}
		else
		{
			System.out.println("Both versions are equal");
		}
		
		
	}
	
	
	public static int getArraysize(String string)
	{
		int count = 1;
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == '.')
			{
				count ++;
			}
		}
		return count;
	}
	
	public static double[] toArray(int size, String string)
	{
		double[] array = new double[size];
		int index = 0;
		String temp = "";
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) != '.')
			{
				temp += string.charAt(i);
			}
			else
			{
				array[index++] = Double.parseDouble(temp);
				temp = "0.";
			}
		}
		array[index++] = Double.parseDouble(temp);
		return array;
	}

}
