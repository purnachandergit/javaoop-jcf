package com.visa.prj.util;

public class ArrayUtil {
	public static int getSum(int [] elements)
	{
		int sum=0;
		for (int i = 0; i < elements.length; i++) {
			sum+=elements[i];
		}
		return sum;
	}
	public static int getCount(int [] elements,int no)
	{
		int count=0;
		for (int i = 0; i < elements.length; i++) {
			if(elements[i]==no)
				count++;
		}
		return count;
	}
	public static void sort(int [] elems)
	{
		for (int i = 0; i < elems.length; i++) {
			for (int j = 0; j < elems.length-i-1; j++) {
				if(elems[j]>elems[j+1])
				{
					int temp;
					temp=elems[j];
					elems[j]=elems[j+1];
					elems[j+1]=temp;
				}
				
			}
		}
		
	}

}
