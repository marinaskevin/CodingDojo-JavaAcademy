package com.marinaskevin.countries.services;

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
}
