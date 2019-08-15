package com.marinaskevin.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="last_name",required=false) String last_name) {
		if(name == null)
		{
			name = "Human";
		}
		if(last_name != null)
		{
			name += " "+last_name;
		}
		return "<h1>Hello "+name+"!</h1><h3>Welcome to SpringBoot!</h3>";
	}

}
