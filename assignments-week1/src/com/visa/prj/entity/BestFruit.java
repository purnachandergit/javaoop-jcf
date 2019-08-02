package com.visa.prj.entity;

public class BestFruit {
	private String name;
	private Integer count;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BestFruit(String name, Integer count) {
		this.name = name;
		this.count = count;
	}
	

}
