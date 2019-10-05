package com.marinaskevin.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marinaskevin.relationships.models.Dojo;
import com.marinaskevin.relationships.models.Ninja;
import com.marinaskevin.relationships.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	public List<Object[]> joinDojosAndNinjas() {
		List<Object[]> table = dojoRepository.joinDojosAndNinjas2();
		for(Object[] row : table) {
		    Dojo dojo = (Dojo) row[0];
		    Ninja ninja = (Ninja) row[1];
		    System.out.println(dojo.getName());
		    System.out.println(ninja.getFirstName());
		}
		return table;
	}
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}
