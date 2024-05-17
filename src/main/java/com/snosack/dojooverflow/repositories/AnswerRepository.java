package com.snosack.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.snosack.dojooverflow.models.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByQuestionIdIs(Long id);

}
