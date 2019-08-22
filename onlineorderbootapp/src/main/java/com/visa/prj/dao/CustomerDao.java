package com.visa.prj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Product;

public interface CustomerDao extends JpaRepository<Customer, String> {
	
	List<Customer> findByEmail(String email);
	
}
