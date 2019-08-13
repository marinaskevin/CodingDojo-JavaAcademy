package com.marinaskevin.routingassignment;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/dojo")
	public String dojo() {
		return "The dojo is awesome!";
	}

	@RequestMapping("/{name}-dojo")
	public String nameDojo(@PathVariable("name") String name) {
		return name.substring(0,1).toUpperCase()+name.substring(1)+" Dojo is located in Southern California";
	}
	
	@RequestMapping("/{name}")
	public String name(@PathVariable("name") String name) {
		String acronym = "";
		for(String word : name.split("-")) {
			acronym += word.substring(0,1).toUpperCase();
		}
		if(acronym.length() == 1) {
			return name.substring(0,1).toUpperCase()+name.substring(1)+" Dojo is located in Southern California";
		}
		else {
			return acronym+" dojo is the headquarters";
		}

	}

}
