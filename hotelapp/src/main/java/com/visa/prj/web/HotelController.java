package com.visa.prj.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
@SessionAttributes("user")
public class HotelController {
	@Autowired
	private BookingService bs;
	
	@RequestMapping("hotels.do")
	public ModelAndView getHotels(@ModelAttribute("searchCriteria") SearchCriteria s)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("searchResults.jsp");
		mav.addObject("hotelList",bs.findHotels(s.getSearchString()));
		return mav;
	}
	
	@RequestMapping("search.do")
	public ModelAndView searchHotels()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("searchForm.jsp");
		mav.addObject("searchCriteria",new SearchCriteria());
		return mav;
	}
	@RequestMapping("viewHotel.do")
	public ModelAndView getHotelDetails(HttpServletRequest req) {
	
		ModelAndView mav=new ModelAndView();
		mav.setViewName("showHotel.jsp");
		System.out.println(req.getParameter("id"));
		mav.addObject("hotel",bs.getHotelById(Integer.parseInt(req.getParameter("id"))));
		return mav;
	}
	
	@RequestMapping("bookingForm.do")
	public ModelAndView getDetails(HttpServletRequest req,@RequestParam("id") int id)
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("userLoginForm.jsp");
		Booking b=new Booking();
		Hotel s=bs.getHotelById(id);
		System.out.println(s);
		b.setHotel(s);
		mav.addObject("booking",b);
		return mav;
	}
	@RequestMapping("login.do")
	public ModelAndView makeBooking(@ModelAttribute("booking") Booking b,@RequestParam("hotel.id") int id,
			@RequestParam("user.email") String email,@RequestParam("user.password") String pwd,Model m)
	{
		m.addAttribute("user", email);
		User u=new User();
		u.setEmail(email);
		u.setPassword(pwd);
		Hotel h=bs.getHotelById(id);
		System.out.println(bs.getHotelById(id));
		b.setUser(u);
		b.setHotel(h);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("bookingForm.jsp");
		mav.addObject("booking",b);
		return mav;
		
	}
	@RequestMapping("placeReservation.do")
	public String Booking(
			@RequestParam("hotel.id") int id,@RequestParam("user.email") String email,
			@RequestParam("checkinDate") Date d1,@RequestParam("checkoutDate") Date d2)
	{
		System.out.println("Place Reservation");
//		System.out.println(bs.getHotelById(id));
//		Booking b=new Booking();
//		b.setCheckinDate(d1);
//		b.setCheckoutDate(d2);
//		b.setSmoking(false);
//		b.setHotel(bs.getHotelById(id));
//		b.setUser(bs.fetchUser(email));
//		
//		System.out.println(b);
		bs.makeBooking(email,id,d1,d2, false, 1);
		//bs.makeBooking(b.getUser(), b.getHotel(), b.getCheckinDate(), b.getCheckoutDate(), b.isSmoking(), b.getBeds());
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("showBookings.jsp");
//		mav.addObject("bookings",bs.getAllBookingsByUser(b.getUser()));
//		return mav;
	//	System.out.println(b);
		return "index.jsp";
		
	}
	@InitBinder
	public void dataTypeBinder(WebDataBinder binder)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,false));
	}
	@RequestMapping("listBookings.do")
	public ModelAndView getBookings(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("showBookings.jsp");
		String email = req.getSession().getAttribute("user").toString();
		User u = bs.fetchUser(email);
		mav.addObject("bookingList",bs.getAllBookingsByUser(u));
		return mav;
	}

}
