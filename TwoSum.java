package com.hiddenleafvillage;

import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = scanner.nextInt();
		}

		int target = scanner.nextInt();
		
		TwoSum ts = new TwoSum();
		int[] res = ts.getSum(a, target);
		System.out.println(res[0] + " " + res[1]);
	}
	
	public int[] getSum(int[] a, int t)
	{
		int[] res = new int[2];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if(i == j)
				{
					continue;
				}
				if(a[i] + a[j] == t)
				{
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
	}

}
