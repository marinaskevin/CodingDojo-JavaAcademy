package com.marinaskevin.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.dojooverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
	List<Answer> findAll();
	List<Answer> findAllByQuestionId(Integer id);
}
