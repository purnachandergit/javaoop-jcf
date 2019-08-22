package com.visa.prj.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@RestController
public class CutomerController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("customers")
	public @ResponseBody List<Customer> getCustomers()
	{
		return orderService.getCustomer();
	}
	
	@GetMapping("customers/{id}")
	public @ResponseBody Customer getCustomer(@PathVariable("id") String id)
	{
		return orderService.getByEmail(id);
	}
	@PostMapping("customers")
	public ResponseEntity<Customer> addCutomer(@RequestBody Customer p)
	{
		orderService.saveCustomer(p);
		return new ResponseEntity<>(p,HttpStatus.CREATED); //201
	}

}
