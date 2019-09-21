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

import com.marinaskevin.relationships.models.Dojo;
import com.marinaskevin.relationships.models.License;
import com.marinaskevin.relationships.models.Ninja;
import com.marinaskevin.relationships.models.Person;
import com.marinaskevin.relationships.services.DojoService;
import com.marinaskevin.relationships.services.LicenseService;
import com.marinaskevin.relationships.services.NinjaService;
import com.marinaskevin.relationships.services.PersonService;

@Controller
public class RelationshipsController {
	private final LicenseService licenseService;
	private final PersonService personService;
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public RelationshipsController(LicenseService licenseService, PersonService personService,
			NinjaService ninjaService, DojoService dojoService) {
		this.licenseService = licenseService;
		this.personService = personService;
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
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
		return "/relationships/show_person.jsp";
	}
	
	@RequestMapping(value="/persons", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result)
	{
		if(result.hasErrors()) {
			return "/relationships/new_person.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/"+person.getId();
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
	
	@RequestMapping("/dojos/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo", new Dojo());
		return "/relationships/new_dojo.jsp";
	}
	
	@RequestMapping("/ninjas/new")
	public String newNinja(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		model.addAttribute("ninja", new Ninja());
		return "/relationships/new_ninja.jsp";
	}
	
	@RequestMapping(value="/dojos", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/dojos/new";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/"+dojo.getId();
		}
	}
	
	@RequestMapping(value="/ninjas", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/ninjas/new";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/"+ninja.getDojo().getId();
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String showNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas = ninjaService.dojoNinjas(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "/relationships/show_dojo.jsp";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
