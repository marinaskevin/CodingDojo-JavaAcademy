package com.marinaskevin.greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HomeController {

	@RequestMapping("")
	public String index() {
		return "This is accessed view http://your_server/simple/root";
	}
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "Hello world! What route did you use to access me?";
	}
	
	@RequestMapping("/goodbye")
	public String world() {
		return "Goodbye world!";
	}
}
