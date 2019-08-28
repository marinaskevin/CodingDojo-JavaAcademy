package com.marinaskevin.ninjagoldgame;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/Gold")
	public String gold(HttpSession session) {
		if(session.getAttribute("gold") == null) session.setAttribute("gold", 0);
		return "gold.jsp";
	}
	
	@RequestMapping("/submit")
	public String submit(@RequestParam("place") String place,HttpSession session) {
		Random random = new Random();
		int moreGold = 0;
		if(place == "farm")	moreGold = random.nextInt(11)+10;
		if(place == "cave") moreGold = random.nextInt(6)+5;
		if(place == "house") moreGold = random.nextInt(4)+2;
		if(place == "casino") moreGold = random.nextInt(101)-50;
		session.setAttribute("gold", moreGold + (Integer)(session.getAttribute("gold") == null ? 0 : session.getAttribute("gold")));
		return "redirect:/Gold";
	}
}
