package com.marinaskevin.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.marinaskevin.authentication.models.User;
import com.marinaskevin.authentication.services.UserService;

// imports removed for brevity
@Controller
public class Users {
    private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "authentication/registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "authentication/loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    	if(result.hasErrors()) {
    		return "authentication/registrationPage.jsp";
    	} else {
    		User u = userService.registerUser(user);
    		session.setAttribute("userId", u.getId());
    		return "redirect:/home";
    	}
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
    	User user = userService.findByEmail(email);
    	if(userService.verifyPassword(email, password)) {
    		session.setAttribute("userId", user.getId());
    		return "redirect:/home";
    	} else {
    		session.removeAttribute("error");
    		redirectAttributes.addFlashAttribute("error", "Invalid user or password");
    		return "redirect:/login";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	Long userId = (Long)session.getAttribute("userId");
    	if(userId == null) {
    		return "redirect:/login";
    	} else {
    		User user = userService.findUserById(userId);
    		model.addAttribute("user",user);
    		return "/authentication/homePage.jsp";
    	}
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("userId");
    	return "redirect:/login";
    }
}