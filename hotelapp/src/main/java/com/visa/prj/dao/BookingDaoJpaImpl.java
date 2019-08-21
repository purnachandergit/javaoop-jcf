package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Repository
public class BookingDaoJpaImpl implements BookingDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hotel> findHotels(String criteria) {
		 String jpql="from Hotel p where p.city=:pr1 or p.name=:pr2";
		 TypedQuery<Hotel> query=em.createQuery(jpql,Hotel.class);
		 query.setParameter("pr1", criteria);
		 query.setParameter("pr2", criteria);
		 return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql="from User u where u.email=:pr1 and u.password=:pr2";
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		query.setParameter("pr1", email);
		query.setParameter("pr2", password);
		return query.getSingleResult();
	}
	@Override
	public User fetchUser(String email)
	{
		String jpql="from User u where u.email=:pr1";
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		query.setParameter("pr1", email);
		return query.getSingleResult();
	}
	@Override
	@Transactional
	public void createBooking(Booking booking) {
		em.persist(booking);
		//return booking.getId();
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql="from Booking u where u.user.email=:pr1";
		TypedQuery<Booking> query=em.createQuery(jpql, Booking.class);
		query.setParameter("pr1", user.getEmail());
		return query.getResultList();
	}

}
