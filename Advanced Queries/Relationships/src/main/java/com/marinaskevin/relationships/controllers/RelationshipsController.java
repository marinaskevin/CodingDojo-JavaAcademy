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
import org.springframework.web.bind.annotation.RequestParam;

import com.marinaskevin.relationships.models.Category;
import com.marinaskevin.relationships.models.Dojo;
import com.marinaskevin.relationships.models.License;
import com.marinaskevin.relationships.models.Ninja;
import com.marinaskevin.relationships.models.Person;
import com.marinaskevin.relationships.models.Product;
import com.marinaskevin.relationships.services.CategoryService;
import com.marinaskevin.relationships.services.DojoService;
import com.marinaskevin.relationships.services.LicenseService;
import com.marinaskevin.relationships.services.NinjaService;
import com.marinaskevin.relationships.services.PersonService;
import com.marinaskevin.relationships.services.ProductService;

@Controller
public class RelationshipsController {
	private final LicenseService licenseService;
	private final PersonService personService;
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	private final ProductService productService;
	private final CategoryService categoryService;

	public RelationshipsController(LicenseService licenseService, PersonService personService,
			NinjaService ninjaService, DojoService dojoService, ProductService productService,
			CategoryService categoryService) {
		this.licenseService = licenseService;
		this.personService = personService;
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
		this.productService = productService;
		this.categoryService = categoryService;
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
	
	@RequestMapping("/ninjas")
	public String showNinjas(Model model) {
		List<Object[]> ninjas = dojoService.joinDojosAndNinjas();
		model.addAttribute("ninjas",ninjas);
		return "/relationships/show_ninjas.jsp";
	}
	
	@RequestMapping("/dojos/{id}")
	public String showNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Ninja> ninjas = ninjaService.dojoNinjas(id);
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "/relationships/show_dojo.jsp";
	}

	@RequestMapping("/products/new")
	public String newProducts(Model model) {
		model.addAttribute("product", new Product());
		return "/relationships/new_product.jsp";
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/products/new";
		} else {
			productService.createProduct(product);
			return "redirect:/products/"+product.getId();
		}
	}

	@RequestMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		List<Category> categories = categoryService.allCategories();
		model.addAttribute("product",product);
		model.addAttribute("categories",categories);
		return "/relationships/show_product.jsp";
	}

	@RequestMapping(value="/products/{id}/edit", method=RequestMethod.PUT)
	public String editProduct(@PathVariable("id") Long product_id, @RequestParam("category") Long category_id) {
		Product product = productService.findProduct(product_id);
		Category category = categoryService.findCategory(category_id);
		productService.addCategory(product, category);
		return "redirect:/products/"+product_id;
	}

	@RequestMapping("/categories/new")
	public String newCategory(Model model) {
		model.addAttribute("category", new Category());
		return "/relationships/new_category.jsp";
	}
	
	@RequestMapping(value="/categories", method=RequestMethod.POST)
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors())
		{
			return "redirect:/categories/new";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/"+category.getId();
		}
	}

	@RequestMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> products = productService.allProducts();
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "/relationships/show_category.jsp";
	}

	@RequestMapping(value="/categories/{id}/edit", method=RequestMethod.PUT)
	public String editCategory(@PathVariable("id") Long category_id, @RequestParam("product") Long product_id) {
		Category category = categoryService.findCategory(category_id);
		Product product = productService.findProduct(product_id);
		categoryService.addProduct(category, product);
		return "redirect:/categories/"+category_id;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
