package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class ProductController {
	
	@Autowired 
	private OrderService os;
	
	@RequestMapping("listproducts.do")
	public ModelAndView getProducts() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("products",os.fetchProducts());
		return mav;
	}
	@RequestMapping("productform.do")
	public ModelAndView getProductForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("form.jsp");
		mav.addObject("product",new Product());
		return mav;
	}
	@RequestMapping("addproduct.do")
	public String addProduct(@ModelAttribute("product") Product p,Model m){
		os.insertProduct(p);
		m.addAttribute("msg", "Product added Successfully");
		return "index.jsp";
	}
	
	
}
