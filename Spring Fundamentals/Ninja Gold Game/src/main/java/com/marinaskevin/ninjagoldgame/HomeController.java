package com.marinaskevin.ninjagoldgame;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@SuppressWarnings("unchecked")
	@RequestMapping("/Gold")
	public String gold(HttpSession session,Model model) {
		if(session.getAttribute("gold") == null) session.setAttribute("gold", 0);
		if(session.getAttribute("messages") == null) session.setAttribute("messages", new ArrayList<Object>());
		model.addAttribute("gold",(Integer)session.getAttribute("gold"));
		model.addAttribute("messages",(ArrayList<Object>)session.getAttribute("messages"));
		return "gold.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/submit",method=RequestMethod.POST)
	public String submit(@RequestParam("place") String place,HttpSession session) {
		Random random = new Random();
		Integer moreGold = 0;
		if(place.equals("farm")) moreGold = random.nextInt(11)+10;
		if(place.equals("cave")) moreGold = random.nextInt(6)+5;
		if(place.equals("house")) moreGold = random.nextInt(4)+2;
		if(place.equals("casino")) moreGold = random.nextInt(101)-50;
		int day = LocalDate.now().getDayOfMonth();
		String suffix = "th";
		if(day % 10 == 1) suffix = "st";
		if(day % 10 == 2) suffix = "nd";
		if(day % 10 == 3) suffix = "rd";
		if(day % 100 > 10 && day % 100 < 14) suffix = "th";
		SimpleDateFormat f = new SimpleDateFormat("MMMM d'"+suffix+"', YYYY h:mm a");
		String dateString = f.format(new Date());
		System.out.println(place);
		System.out.println(moreGold);
		System.out.println(dateString);
		Object[] message_data = {place,moreGold,dateString};
		if(moreGold != 0) ((ArrayList<Object>)session.getAttribute("messages")).add(message_data);
		session.setAttribute("gold", moreGold + (Integer)session.getAttribute("gold"));
		return "redirect:/Gold";
	}
}
