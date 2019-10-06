package com.marinaskevin.countries.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.countries.models.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer> {
	List<City> findAll();
}
