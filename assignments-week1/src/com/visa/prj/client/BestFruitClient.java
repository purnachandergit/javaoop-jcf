package com.visa.prj.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.visa.prj.entity.BestFruit;

public class BestFruitClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BestFruit> fruits=new ArrayList<>();
		fruits.add(new BestFruit("Mango",121));
        fruits.add(new BestFruit("Apple",120));
		fruits.add(new BestFruit("Orange",123));
		fruits.add(new BestFruit("Pear",121));
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			String s=sc.nextLine();
			Integer k=find(fruits,s);
			if(k!=-1) {
				Integer count=fruits.get(k).getCount();
				fruits.get(k).setCount(1+count);
			}
			else
			{
				fruits.add(new BestFruit(s,1));
			}
			fruits.sort(new Comparator<BestFruit>() {
				@Override
				public int compare(BestFruit bf1, BestFruit bf2)
				{
					return bf2.getCount()-bf1.getCount();
				}
				
			});
			for (Iterator iterator = fruits.iterator(); iterator.hasNext();) {
				BestFruit bestFruit = (BestFruit) iterator.next();
				System.out.println(bestFruit.getName() + " "+ bestFruit.getCount());
			}
		}
		
		
		//Map<String,Integer> map1=map1.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
		//.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)-> e1,LinkedHashMap::new);

	}
	public static Integer find(List<BestFruit> fruits,String name)
	{
		for (int i = 0; i <fruits.size(); i++) {
			if(fruits.get(i).getName().compareTo(name)==0)
			{
				return i;
			}
			
		}
		return -1;
		
	}

}
