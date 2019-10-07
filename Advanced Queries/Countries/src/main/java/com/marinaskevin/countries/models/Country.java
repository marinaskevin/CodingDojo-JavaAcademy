package com.marinaskevin.countries.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="countries")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private Integer id;
	@Column(length = 3)
	private String code;
	@Column(length = 52)
	private String name;
	@Column(length = 26)
	private String region;
	private String continent;
	@Column(precision = 10, scale = 2)
	private Float surface_area;
	@Column(length = 6)
	private Short indep_year;
	@Column(length = 11)
	private Integer population;
	@Column(precision = 3, scale = 1)
	private Float life_expectancy;
	@Column(precision = 10, scale = 2)
	private Float gnp;
	@Column(precision = 10, scale = 2)
	private Float gnp_old;
	@Column(length = 45)
	private String local_name;
	@Column(length = 45)
	private String government_form;
	@Column(length = 60)
	private String head_of_state;
	@Column(length = 11)
	private Integer capital;
	@Column(length = 2)
	private String code2;
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<City> cities;
	@OneToMany(mappedBy="country", fetch = FetchType.LAZY)
	private List<Language> languages;

	public Country() {

	}

	public Country(String code, String name, String continent, Float surface_area, Short indep_year,
			Integer population, Float life_expectancy, Float gnp, Float gnp_old, String local_name,
			String government_form, String head_of_state, Integer capital, String code2, List<City> cities,
			List<Language> languages) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.surface_area = surface_area;
		this.indep_year = indep_year;
		this.population = population;
		this.life_expectancy = life_expectancy;
		this.gnp = gnp;
		this.gnp_old = gnp_old;
		this.local_name = local_name;
		this.government_form = government_form;
		this.head_of_state = head_of_state;
		this.capital = capital;
		this.code2 = code2;
		this.cities = cities;
		this.languages = languages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Float getSurface_area() {
		return surface_area;
	}

	public void setSurface_area(Float surface_area) {
		this.surface_area = surface_area;
	}

	public Short getIndep_year() {
		return indep_year;
	}

	public void setIndep_year(Short indep_year) {
		this.indep_year = indep_year;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public Float getLife_expectancy() {
		return life_expectancy;
	}

	public void setLife_expectancy(Float life_expectancy) {
		this.life_expectancy = life_expectancy;
	}

	public Float getGnp() {
		return gnp;
	}

	public void setGnp(Float gnp) {
		this.gnp = gnp;
	}

	public Float getGnp_old() {
		return gnp_old;
	}

	public void setGnp_old(Float gnp_old) {
		this.gnp_old = gnp_old;
	}

	public String getLocal_name() {
		return local_name;
	}

	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}

	public String getGovernment_form() {
		return government_form;
	}

	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}

	public String getHead_of_state() {
		return head_of_state;
	}

	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}

	public Integer getCapital() {
		return capital;
	}

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}	
}