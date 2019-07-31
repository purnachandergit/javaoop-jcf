package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.visa.prj.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Product> products = new ArrayList<>();
		products.add(new Product(645,"Hp Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"Logitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"Sony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"One Plus",32000.00,"mobile",100));
		products.add(new Product(88,"HP Printer",19000.00,"computer",100));
		
		
		Map<String,List<Product>> catMap=products.stream().collect(Collectors.groupingBy(p->p.getCategory())) ;
		
		Set<String> keys=catMap.keySet();
		for (String string : keys) {
			System.out.println(string);
			List<Product> prds=catMap.get(string);
			prds.forEach(System.out::println);
		}
		
		catMap.forEach((k,v)->{
			System.out.println(k);
			v.forEach(System.out::println);
		});
		
//		products.stream().filter(p->p.getCategory().equals("mobile")).forEach(p->System.out.println(p));
//		
//		List<String> names=products.stream().map(p->p.getName()).collect(Collectors.toList());
//		for (String string : names) {
//			System.out.println(string);
//		}
//		
//		double total=products.stream().map(p->p.getPrice()).reduce(0.0,(v1,v2)->v1+v2);
//		System.out.println(total);
//		
//		products.stream().map(p->p.getPrice()).forEach(System.out::println);
//		
//		
//		
		
		
		
		
//		Stream<Product> mobiles=products.stream().filter(p->{
//			System.out.println("Puri");                 //this explains laziness of stream without terminal operations
//		return p.getCategory().equals("mobile");});
//		mobiles.forEach(p->System.out.println(p));
		
		
		
//		System.out.println("for each");
//		
//		Collections.sort(products,(p1,p2)->Double.compare(p1.getPrice(),p2.getPrice()));
//		for (Product product : products) {
//			System.out.println(product);
//		}
		
		/*
		Iterator<Product> iter=products.iterator();
		while(iter.hasNext())
		{
			Product p=iter.next();
			System.out.println(p);
		}
		
		System.out.println("Index Based  : Avoid ");
		for (int i = 0; i < products.size(); i++) {
			System.out.println(products.get(i));
		}
		//Iterator can remove conditionally but for each is only for traversing
		//after Iterator is fixed it gives lock and it shows error if we add something 
		//where as for loop goes to infinite loop
		*/
		 

	}

}
