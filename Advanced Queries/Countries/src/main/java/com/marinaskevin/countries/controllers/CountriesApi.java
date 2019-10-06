package com.marinaskevin.countries.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesApi {

	@RequestMapping("/")
	public String dashboard() {
		return "Hello";
	}
}
