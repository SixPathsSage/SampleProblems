package edu.hiddenleafvillage;

import java.io.IOException;

public class Client {

	public static void main(String[] args) {
		CustomList<Integer> list = new CustomList<>(Integer.class);
		list.add(10);
		list.add(19);
		list.add(50);
		list.add(99);
		
		Exception ex = new IOException();
		CustomList<Exception> exList = new CustomList<>(Exception.class);
		exList.add(ex);
		
		list.remove(99);
		
		for (int i = 0; i < list.length(); i++) {
			System.out.println(list.get(i));
		}
	}

}
