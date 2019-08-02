package com.visa.prj.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> zonalDetails=new HashMap<String,String>();
		zonalDetails.put("KA-01","koramangala");
		zonalDetails.put("KA-02","rajajinagar");
		zonalDetails.put("KA-03","indiranagar");
		zonalDetails.put("KA-04","yeshwanthapur");
		zonalDetails.put("KA-50","jayanagar");
		zonalDetails.put("KA-50","yelahanka");
		zonalDetails.put("KA-51","electronic");
		zonalDetails.put("KA-52","nelamangala");
		zonalDetails.put("KA-53","krpuram");
		zonalDetails.put("KA-54","nagamangala");
		zonalDetails.put("KA-55","mysore");
		zonalDetails.put("KA-56","baavakalyan");
		zonalDetails.put("KA-57","shantinagar");
		
		List<String> list1=new ArrayList<String>();
		list1.add("KA-55-AB-4555");
		list1.add("KA-01-EF-4444");
		list1.add("KA-04-AB-9000");
		list1.add("KA-56-200");
		list1.add("KA-50-T-3111");
		list1.add("KA-02-AG-9243");
		sort(list1,zonalDetails);
	    System.out.println(list1);
	    
	    List<String> list2=new ArrayList<String>();
		list2.add("KA-57-DE-111");
		list2.add("KA-51-A-9");
		list2.add("KA-04-500");
		list2.add("KA-02-L-41");
		sort(list2,zonalDetails);
	    System.out.println(list2);
	    
	    List<String> list3=new ArrayList<String>();
		list3.add("KA-57-DE-111");
		list3.add("KA-51-A-9");
		list3.add("KA-04-500");
		list3.add("KA-02-L-41");
		list3.add("KA-57-AB-9011");
		sort(list3,zonalDetails);
	    System.out.println(list3);
	}

	private static void sort(List<String> list1,Map<String,String> details) {
		// TODO Auto-generated method stub
		//System.out.println("size:" + list1.size());
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0; j < list1.size()-1-i; j++) {
				//System.out.println("i:"+i+" j:"+j);
				String s1=details.get(list1.get(j).substring(0,5));
				String s2=details.get(list1.get(j+1).substring(0,5));
				//System.out.println("s1:"+s1+" s2:"+s2);
				if(s1.compareTo(s2)>0)
				{
				   String temp;
				   temp=list1.get(j);
				   list1.set(j,list1.get(j+1));
				   list1.set(j+1,temp);
				}
				else if(s1.compareTo(s2)==0)
				{
					if(list1.get(j).compareTo(list1.get(j+1))>0)
					{
						String temp;
						temp=list1.get(j);
						list1.set(j,list1.get(j+1));
						list1.set(j+1,temp);
					}
				}
				
			}
			
		}
		
	}

}
