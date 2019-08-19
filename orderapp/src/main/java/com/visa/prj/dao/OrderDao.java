package com.visa.prj.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Order;

@Repository
public interface OrderDao {

    void placeOrder(Order o);
    List<Order> getOrders(Customer c);
//  List<Order> getOrdersOfCustomer(Customer c);
}
