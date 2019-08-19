package com.visa.prj.web;

import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.service.BookingService;

@Controller
public class HotelController {
	@Autowired
	private BookingService bs;
	
	@RequestMapping("search.do")
	public ModelAndView getHotels()
	{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("list.jsp");
		mav.addObject("hotels",bs.findHotels());
		return mav;
	}

}
