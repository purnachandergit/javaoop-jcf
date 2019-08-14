package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//create spring container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		
		OrderService os=ctx.getBean("orderService",OrderService.class);
//		
//		Product p=new Product(0,"LogiTech Mouse","computer",450.00,1000);
//		
//		os.insertProduct(p);
//		System.out.println("Inserted : "+p.getId());
//		
//		p=os.getById(1);
//		System.out.println(p.getName()+","+p.getCategory()+","+p.getPrice());
		
		
		List<Product> list=os.fetchProducts();
		for (Product p : list) {
			System.out.println(p.getName()+","+p.getPrice());
		}

	}

}
