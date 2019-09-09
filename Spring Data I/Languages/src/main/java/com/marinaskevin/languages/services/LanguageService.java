package com.marinaskevin.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marinaskevin.languages.models.Language;
import com.marinaskevin.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}
	
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	
	public Language createLanguage(Language l) {
		return languageRepository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	
	public Language updateLanguage(Long id, String name, String creator, String currentVersion) {
		Language language = findLanguage(id);
		language.setName(name);
		language.setCreator(creator);
		language.setCurrentVersion(currentVersion);
		languageRepository.save(language);
		return language;
	}
	
	public void deleteLanguage(Long id) {
		Language language = findLanguage(id);
		languageRepository.delete(language);
	}
}
