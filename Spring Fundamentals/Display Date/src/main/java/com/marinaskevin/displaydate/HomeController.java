package com.marinaskevin.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat f = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, YYYY");
		model.addAttribute("date",f.format(new Date()));
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat f = new SimpleDateFormat("hh:mm a");
		model.addAttribute("time",f.format(new Date()));		
		return "time.jsp";
	}
	
}
