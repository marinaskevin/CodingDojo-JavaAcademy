package com.marinaskevin.events.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marinaskevin.events.models.Event;
import com.marinaskevin.events.models.User;
import com.marinaskevin.events.services.EventService;
import com.marinaskevin.events.validator.UserValidator;

@Controller
public class Events {
	private final EventService eventService;
	private final UserValidator userValidator;
	
	public Events(EventService eventService, UserValidator userValidator) {
		this.eventService = eventService;
		this.userValidator = userValidator;
	}

	@RequestMapping("/")
	public String welcome(Model model, HttpSession session) {
		if(session.getAttribute("userId") != null) {
			return "redirect:/events";
		}
		model.addAttribute("user", new User());
		return "events/welcome.jsp";
	}
	
	@RequestMapping("/events")
	public String events(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = eventService.findUserById((Long)session.getAttribute("userId"));
		List<Event> eventsInState = eventService.findEventsInState((String)user.getState());
		List<Event> eventsNotInState = eventService.findEventsNotInState((String)user.getState());
		model.addAttribute("user", user);
		model.addAttribute("eventsInState", eventsInState);
		model.addAttribute("eventsNotInState", eventsNotInState);
		model.addAttribute("event", new Event());
		return "events/events.jsp";
	}
	
	@RequestMapping("/events/{id}")
	public String event(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "events/show_event.jsp";
	}
	
	@RequestMapping("/events/{id}/edit")
	public String editEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}		
		return "events/edit_event.jsp";
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public String newUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			return "events/welcome.jsp";
		}
		User u = eventService.createUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/events";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		User user = eventService.findUserByEmail(email);
		if(eventService.verifyPassword(email, password)) {
			session.setAttribute("userId", user.getId());
			return "redirect:/events";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.removeAttribute("userId");
		return "redirect:/";
	}
	
	@RequestMapping(value="/events", method=RequestMethod.POST)
	public String newEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "redirect:/events";
		} else {
			User user = eventService.findUserById((Long)session.getAttribute("userId"));
			event.setHost(user);
			eventService.createEvent(event);
			return "redirect:/events";
		}
	}
	
	@RequestMapping(value="/events/{id}", method=RequestMethod.PUT)
	public String updateEvent(@Valid @ModelAttribute("event") Event event, @PathVariable("id") Long id, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/events/{id}/edit";
		} else {
			eventService.updateEvent(event);
		}
		return "redirect:/events/"+id;
	}
}
