package com.marinaskevin.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marinaskevin.dojooverflow.models.Answer;
import com.marinaskevin.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;

	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	public List<Answer> allAnswers() {
		return this.answerRepository.findAll();
	}

	public List<Answer> questionAnswers(Integer id) {
		return this.answerRepository.findAllByQuestionId(id);
	}

	public Answer findAnswer(Integer id) {
		Optional<Answer> optionalAnswer = this.answerRepository.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}
}
