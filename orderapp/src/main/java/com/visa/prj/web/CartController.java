package com.visa.prj.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class CartController {
	
	@Autowired 
	private OrderService os;
	
	@RequestMapping("cart.do")
	public String addToCart(HttpServletRequest req) {
		os.addToCart(req);
		return "index.jsp";
	}
}