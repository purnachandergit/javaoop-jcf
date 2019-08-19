package com.visa.prj.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.prj.service.BookingService;

@Controller
public class BookingController {
	@Autowired
	private BookingService bs;
	
	@RequestMapping("cart.do")
	public String AddToCart(HttpServletRequest req)
	{
		bs.bookHotels(req);
		return index.jsp;
	}
	

}
