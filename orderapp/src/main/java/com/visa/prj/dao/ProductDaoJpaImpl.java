package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;


@Repository
public class ProductDaoJpaImpl implements ProductDao {
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return em.find(Product.class,id);
	}

	@Override
	public int addProduct(Product p) {
		// TODO Auto-generated method stub
		em.persist(p);                              //it gives insert query
		return p.getId();
		//System.out.println("Product Added");
		//return 0;
	}

}
