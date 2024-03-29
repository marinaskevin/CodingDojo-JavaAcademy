package com.marinaskevin.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marinaskevin.countries.repositories.CityRepository;
import com.marinaskevin.countries.repositories.CountryRepository;
import com.marinaskevin.countries.repositories.LanguageRepository;

@Service
public class ApiService {
	public final CityRepository cityRepository;
	public final CountryRepository countryRepository;
	public final LanguageRepository languageRepository;

	public ApiService(CityRepository cityRepository, CountryRepository countryRepository,
			LanguageRepository languageRepository) {
		this.cityRepository = cityRepository;
		this.countryRepository = countryRepository;
		this.languageRepository = languageRepository;
	}
	
//    What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language, and language percentage. Your query should arrange the result by language percentage in descending order.
	public List<Object[]> results() {
		return countryRepository.query1();
//		return countryRepository.query2();
//		return countryRepository.query3();
//		return countryRepository.query4();
//		return countryRepository.query5();
//		return countryRepository.query6();
//		return countryRepository.query7();
//		return countryRepository.query8();
	}
//    What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order.
//    What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order.
//    What query would you run to get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order.
//    What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
//    What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
//    What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District, and Population.
//    What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order.
}
