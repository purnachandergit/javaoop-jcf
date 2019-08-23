package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
@SessionAttributes("user")
public class ProductController {
	
	@Autowired 
	private OrderService os;
	
	@Autowired
	private ProductValidator validator;
	
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
	public String addProduct(@ModelAttribute("product") Product p,BindingResult errors,Model m){
		validator.validate(p, errors);
		if(errors.hasErrors())
		{
			return "form.jsp";
		}
		else
		{
			os.insertProduct(p);
			m.addAttribute("msg", "Product added Successfully");
			return "index.jsp";
		}
	}
	
	
}
