package com.marinaskevin.dojosurvey;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(HttpSession session, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment) {
		if(language.equals("Java"))
		{
			return "redirect:/java";
		}
		session.setAttribute("name",name);
		session.setAttribute("location",location);
		session.setAttribute("language",language);
		session.setAttribute("comment",comment);
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String results(HttpSession session, Model model) {
		System.out.println("Name is "+session.getAttribute("name"));
		model.addAttribute("name",session.getAttribute("name"));
		model.addAttribute("location",session.getAttribute("location"));
		model.addAttribute("language",session.getAttribute("language"));
		model.addAttribute("comment",session.getAttribute("comment"));
		return "result.jsp";
	}
	
	@RequestMapping("/java")
	public String java() {
		return "java.jsp";
	}
	
}
