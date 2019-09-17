package com.marinaskevin.relationships.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marinaskevin.relationships.models.License;
import com.marinaskevin.relationships.models.Person;
import com.marinaskevin.relationships.services.LicenseService;
import com.marinaskevin.relationships.services.PersonService;

@Controller
public class RelationshipsController {
	private final LicenseService licenseService;
	private final PersonService personService;

	public RelationshipsController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(Model model) {
		model.addAttribute("person", new Person());
		return "/relationships/new_person.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model) {
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons", persons);
		model.addAttribute("license", new License());
		return "/relationships/new_license.jsp";
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPerson(id);
		License license = licenseService.findLicense(person);
		if(person==null) return "redirect:/persons/new";
		model.addAttribute(person);
		if(license==null) return "redirect:/licenses/new";
		model.addAttribute(license);
		return "/relationships/show.jsp";
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result)
	{
		if(result.hasErrors()) {
			return "/relationships/new_person.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result)
	{
		if(result.hasErrors()) {
			return "/relationships/new_license.jsp";
		} else {
			licenseService.createLicense(license);
			return "redirect:/persons/"+license.getPerson().getId();
		}
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
