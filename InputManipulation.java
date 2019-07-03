package edu.hiddenleafvillage;

import java.util.Scanner;

public class InputManipulation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		
		String[] q = s.split("\\s+");
		
		for (int i = 0; i < Integer.parseInt(q[1]); i++) {
			System.out.println(q[0]);
		}
	}

}
