package com.visa.prj.client;

import com.visa.prj.entity.Product;
import com.visa.prj.util.SQLUtil;

public class SQLClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String CREATE_SQL=SQLUtil.generateCreateSQL(Product.class);
		System.out.println(CREATE_SQL);
		Product[] products = new Product[6];
		products[0] = new Product(645,"Hp Laptop",135000.00,"computer",100);
		products[1] = new Product(224,"iPhone",98000.00,"mobile",500);
		products[2] = new Product(834,"Logitech Mouse",600.00,"computer",300);
		products[3] = new Product(5,"Sony Bravia",125000.00,"tv",900);
		products[4] = new Product(912,"One Plus",32000.00,"mobile",100);
		products[5] = new Product(88,"HP Printer",19000.00,"computer",100);
		for (int i = 0; i < products.length; i++) {
			String INSERT_SQL=SQLUtil.generateInsertSQL(products[i]);
			System.out.println(INSERT_SQL);
		}
		
	}

}
