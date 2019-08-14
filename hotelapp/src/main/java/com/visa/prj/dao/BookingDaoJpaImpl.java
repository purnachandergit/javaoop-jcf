package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
		 query.setParameter(1, criteria);
		 query.setParameter(2, criteria);
		 return query.getResultList();
	}

	@Override
	public Hotel findHotelById(long id) {
		
		return em.find(Hotel.class, id);
	}

	@Override
	public User getUser(String email, String password) {
		String jpql="from User u where u.username=:pr1 and u.password=:pr2";
		TypedQuery<User> query=em.createQuery(jpql, User.class);
		query.setParameter(1, email);
		query.setParameter(2, password);
		return query.getSingleResult();
	}

	@Override
	public long createBooking(Booking booking) {
		return 0;
	}

	@Override
	public List<Booking> getAllBookingsOfUser(User user) {
		String jpql="from Booking u where u.user:pr1";
		TypedQuery<Booking> query=em.createQuery(jpql, Booking.class);
		query.setParameter(1, user);
		return query.getResultList();
	}

}
