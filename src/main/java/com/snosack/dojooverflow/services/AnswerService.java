package com.snosack.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snosack.dojooverflow.models.Answer;
import com.snosack.dojooverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	@Autowired
	private AnswerRepository aRepo;
	
	public List<Answer> questionAnswers(Long questionId) {
		return aRepo.findByQuestionIdIs(questionId);
	}
	
	public Answer addAnswer(Answer answer) {
		return aRepo.save(answer);
	}

}
