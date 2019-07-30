package com.visa.prj.entity;

public abstract class Product implements Comparable<Product> {//abstract because its too generic and it can't exist on its own
	private int id;
	private String name;
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product() {
	}
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	public abstract boolean isExpensive();
	@Override
		public int compareTo(Product o) {
			// TODO Auto-generated method stub
			return Double.compare(this.price, o.price);
		}

	
//we can create new instance of abstract class but we can instantiate array of classes since they r pointers in case of array
//Java doesn't support multiple inheritance
//Object is the super class for all objects
//constructor chaining super()
//constructor chain with a class this()
/*
 * A(){}
 * A(int x)
 * {
 *  this();
 *  }
 */
}
