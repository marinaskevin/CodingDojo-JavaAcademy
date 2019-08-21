package com.marinaskevin.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpSession session) {
		Integer count = (Integer)session.getAttribute("count");
		if(count == null)
		{
			count = 0;
		}
		session.setAttribute("count", count+1);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer count = (Integer)session.getAttribute("count");
		if(count == null)
		{
			count = 0;
		}
		model.addAttribute("visits",count);
		return "counter.jsp";
	}
	
	@RequestMapping("/doublecount")
	public String doublecount(HttpSession session) {
		Integer count = (Integer)session.getAttribute("count");
		if(count == null)
		{
			count = 0;
		}
		session.setAttribute("count", count+2);
		return "doublecount.jsp";		
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "reset.jsp";		
	}

}
