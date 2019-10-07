package com.marinaskevin.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	List<Country> findAll();

//	What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language, and language percentage. Your query should arrange the result by language percentage in descending order.
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
	List<Object[]> query1();

//	What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order.
	@Query("SELECT c.name, c.cities.size FROM Country c ORDER BY c.cities.size DESC")
	List<Object[]> query2();

//	What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order.
	@Query("SELECT c.name, t.name, t.population FROM Country c JOIN c.cities t WHERE c.name = 'Mexico' AND t.population > 500000 ORDER BY t.population DESC")
	List<Object[]> query3();

//	What query would you run to get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order. 
	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > 89 ORDER BY l.percentage DESC")
	List<Object[]> query4();

//	What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?
	@Query("SELECT c.name, c.surface_area, c.population FROM Country c WHERE surface_area < 501 AND population > 100000")
	List<Object[]> query5();

//	What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?
	@Query("SELECT c.name, c.government_form, c.surface_area, c.life_expectancy FROM Country c WHERE c.government_form = 'Constitutional Monarchy' AND c.surface_area > 200 AND c.life_expectancy > 75")
	List<Object[]> query6();

//	What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District, and Population.
	@Query("SELECT c.name, t.name, t.district, t.population FROM Country c JOIN c.cities t WHERE c.name = 'Argentina' AND t.district = 'Buenos Aires' AND t.population > 500000")
	List<Object[]> query7();

//	What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order.
	@Query("SELECT c.region, COUNT(c) FROM Country c GROUP BY c.region ORDER BY COUNT(c) DESC")
	List<Object[]> query8();
}
