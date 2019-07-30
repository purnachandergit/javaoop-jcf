package com.visa.prj.client;

import java.util.Arrays;

public class ComparableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names= {"Lee","Kevin","Angelina","George","Brad"};
		//Arrays.sort(names); predefined
		Arrays.sort(names,(s1,s2)->s1.length()-s2.length()); //customized based on the condition
		for (String string : names) {
			System.out.println(string);
		}

	}

}
