package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Hotel;
import com.visa.prj.service.BookingService;

public class HotelClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		BookingService bs=ctx.getBean("bookingService",BookingService.class);
		
		List<Hotel> hotel_list=bs.findHotels("Doubletree");
		for (Hotel hotel : hotel_list) {
			System.out.println(hotel);
		}
		Hotel h=bs.getHotelById(3);
		System.out.println(h);
	}

}
