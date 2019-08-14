package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;


@Repository
public class ProductDaoJpaImpl implements ProductDao {
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		String jpql="from Product"; //select p from Product p ,here Product is a class not table since jpql uses query with classes
		//jpql is fine till there is bulk updates
		TypedQuery<Product> query=em.createQuery(jpql,Product.class);
				
		return query.getResultList();
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
