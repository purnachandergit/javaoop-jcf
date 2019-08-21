//package com.visa.prj.web;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.visa.prj.entity.Booking;
//import com.visa.prj.entity.SearchCriteria;
//import com.visa.prj.entity.User;
//import com.visa.prj.service.BookingService;
//
//@Controller
//public class BookingController {
//	@Autowired
//	private BookingService bs;
//	@RequestMapping("listbookings.do")
//	public ModelAndView getBookings(HttpServletRequest req) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("showBookings.jsp");
//		String email = req.getSession().getAttribute("user").toString();
//		User u = bs.fetchUser(email);
//		mav.addObject("bookingList",bs.getAllBookingsByUser(u));
//		return mav;
//	}
//	@RequestMapping("search.do")
//	public ModelAndView searchHotels() 
//		
//		{
//			ModelAndView mav=new ModelAndView();
//			mav.setViewName("searchForm.jsp");
//			mav.addObject("searchCriteria",new SearchCriteria());
//			return mav;
//		}
//	
//	@RequestMapping("hotels.do")
//	public ModelAndView getHotels(@ModelAttribute("searchCriteria") SearchCriteria s)
//	{
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("searchResults.jsp");
//		mav.addObject("hotelList",bs.findHotels(s.getSearchString()));
//		return mav;
//	}
//	@RequestMapping("bookingForm.do")
//	public String createBooking(Model m,HttpServletRequest req) {
//		Booking b = new Booking();
//		String s = req.getParameter("id").toString();
//		b.setHotel(bs.getHotelById(Integer.parseInt(s)));
//		String email = req.getSession().getAttribute("user").toString();
//		b.setUser(bs.fetchUser(email));
//		System.out.println(b);
//		req.getSession().setAttribute("booking", b);
//		m.addAttribute("booking", b);
//		return "bookingForm.jsp";
//	}
//	@RequestMapping("login.do")
//	public ModelAndView makeBooking(@ModelAttribute("booking") Booking b,
//			@RequestParam("user.email") String email,@RequestParam("user.password") String pwd,Model m)
//	{
//		User u=new User();
//		u.setEmail(email);
//		u.setPassword(pwd);
//		m.addAttribute("user",email);
//		System.out.println(b.getHotel());
//		b.setUser(u);
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("bookingForm.jsp");
//		mav.addObject("booking",b);
//		return mav;
//		
//	}
//	@RequestMapping("placeReservation.do")
//	public ModelAndView reserve(HttpServletRequest req, Model m) {
//		ModelAndView mav = new ModelAndView();
//		Booking b = (Booking) req.getSession().getAttribute("booking");
//		System.out.println(b);
//		long id = bs.createBooking(b);
//		System.out.println("Booking with " +id + " has been created");
//		m.addAttribute("msg1","Booking has been done successfully");
//		List<Booking> bookList=  bs.getAllBookingsByUser(b.getUser());
//		System.out.println(bookList);
//		mav.addObject("bookingList", bs.getAllBookingsByUser(b.getUser()));
//		mav.setViewName("showBookings.jsp");
//		return mav;
//	}
//	@RequestMapping("showHotel.do")
//	public ModelAndView showHotel(Model m,HttpServletRequest req) {
//		ModelAndView mav = new ModelAndView();
//		//m.addAttribute("hotel",new Hotel());
//		String s = req.getParameter("id").toString();
//		m.addAttribute("hotel",bs.getHotelById(Integer.parseInt(s)));
//		mav.setViewName("showHotel.jsp");
//		return mav;
//	}
//	
//}
//
//
//
//
