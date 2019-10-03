package com.marinaskevin.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.relationships.models.License;
import com.marinaskevin.relationships.models.Person;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
	License findByPerson(Person person);
}
