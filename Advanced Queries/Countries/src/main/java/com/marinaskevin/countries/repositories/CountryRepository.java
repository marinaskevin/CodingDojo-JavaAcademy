package com.marinaskevin.countries.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	List<Country> findAll();
}
