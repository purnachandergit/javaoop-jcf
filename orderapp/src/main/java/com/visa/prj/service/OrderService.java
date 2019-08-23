package com.visa.prj.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.OrderDao;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;

@Service
public class OrderService {

    @Autowired
    private ProductDao productDao;
    
    @Autowired
    private OrderDao orderDao;
    
    @Transactional
    public void placeOrder(Order o) {
        orderDao.placeOrder(o);
        double total = 0.0;
        List<Item> items = o.getItems();
        for (Item item : items) {
            total += item.getAmount();
            Product p = getById(item.getProduct().getId());
            p.setCount(p.getCount()- item.getQty());
        }
        o.setTotal(total);
    }
    
    public List<Order> getOrders(Customer c)
    {
        return orderDao.getOrders(c);
    }
    
    @Transactional
    public int insertProduct(Product p)
    {
        return productDao.addProduct(p);
    }
    
    public List<Product> fetchProducts()
    {
        return productDao.getProducts();
    }
    
    public Product getById(int id)
    {
        return productDao.getProduct(id);
    }
    @Transactional
    public void addToCart(HttpServletRequest req)
    {
    	String[] prds = req.getParameterValues("prds"); // only product ids
		// Get product for product id
		// create Item object
		// add product to item
		// create Order object
		// set customer to order based on who has logged
		// place order
		
		Order order=new Order();
		List<Item> items=new ArrayList<>();
		for (String string : prds) {
		    Product p=this.getById(Integer.parseInt(string));
		    Item item=new Item();
		    item.setProduct(p);
		    item.setQty(1);
		    item.setAmount(p.getPrice());
		    items.add(item);
		}
		order.setItems(items);
		HttpSession ses=req.getSession();
		Customer c=new Customer();
		c.setEmail(ses.getAttribute("user").toString());
		order.setCustomer(c);
		placeOrder(order);
    }
}
