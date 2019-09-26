package com.marinaskevin.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
	List<Question> findAll();
	List<Question> findAllByTags(Integer id);
}
