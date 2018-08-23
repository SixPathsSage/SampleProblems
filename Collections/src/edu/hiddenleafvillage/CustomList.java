package edu.hiddenleafvillage;

import java.lang.reflect.Array;

public class CustomList<T> {
	private Class<T> cl;
	private T[] array;
	private int capacity = 1;
	private int length = 0;
	@SuppressWarnings("unchecked")
	CustomList(Class<T> c)
	{
		this.cl = c;
		array = (T[]) Array.newInstance(c, capacity);
	}
	
	public void add(T element)
	{
		expandIfNeed();
		array[length++] = element;
	}
	
	public void insert(T element, int index)
	{
		expandIfNeed();
		if(index < length)
		{
			for(int i = length-1; i >= index; i--)
			{
				array[i+1] = array[i];
			}
			array[index] = element;
			length++;
		}
		else
		{
			System.err.println("Index out of bound");
			throw new IndexOutOfBoundsException("Index out of bound");
		}
	}
	
	public void remove(T element)
	{
		removeAt(getIndex(element));
	}
	
	public void removeAt(int index)
	{
		for(int i = index; i < length-1; i++)
		{
			array[i] = array[i+1];
		}
		length--;
	}
	
	private int getIndex(T element)
	{
		for(int i = 0; i < length; i++)
		{
			if(array[i] == element)
			{
				return i;
			}
		}
		return -1;
	}
	
	public T get(int index)
	{
		return array[index];
	}
	
	public T[] get()
	{
		return array;
	}
	
	@SuppressWarnings("unchecked")
	private void expandIfNeed()
	{
		if(length >= capacity)
		{
			capacity *= 2;
			T[] newArray = (T[]) Array.newInstance(cl, capacity);
			for(int i = 0; i < array.length; i ++)
			{
				newArray[i] = array[i];
			}
			array = newArray;
		}
	}

	public int capacity() {
		return capacity;
	}

	public int length() {
		return length;
	}
}
