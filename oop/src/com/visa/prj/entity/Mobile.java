package com.visa.prj.entity;

public class Mobile extends Product {
    private String connectivity;

    public Mobile(int id, String name, double price) {
	     super(id, name, price);
    }

    public Mobile(int id, String name, double price, String connectivity) {
	    super(id, name, price);
	    this.connectivity = connectivity;
    }

	public Mobile() {
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}
    @Override
    public boolean isExpensive() {
    	if("3G".equals(connectivity) && getPrice()> 5000) {
    		return true; //good
    	}
    	else if (connectivity.equals("4G") && getPrice()>15000)
    	{
    		return true; //bad
    	}
    	return false;
    }
    
 
}
