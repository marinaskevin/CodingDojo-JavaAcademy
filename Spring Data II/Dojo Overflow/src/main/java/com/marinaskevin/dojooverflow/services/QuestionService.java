package com.marinaskevin.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marinaskevin.dojooverflow.models.Question;
import com.marinaskevin.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;

	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	public List<Question> allQuestions() {
		return this.questionRepository.findAll();
	}

	public List<Question> tagQuestions(Integer id) {
		return this.questionRepository.findAllByTags(id);
	}

	public Question findQuestion(Integer id) {
		Optional<Question> optionalQuestion = this.questionRepository.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
}
