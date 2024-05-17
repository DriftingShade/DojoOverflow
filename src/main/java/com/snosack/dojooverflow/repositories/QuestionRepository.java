package com.snosack.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.snosack.dojooverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {
	List<Question> findAll();
	Question findByIdIs(Long id);

}
