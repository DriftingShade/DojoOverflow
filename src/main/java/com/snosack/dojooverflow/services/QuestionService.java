package com.snosack.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snosack.dojooverflow.models.Question;
import com.snosack.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	
	public List<Question> allQuestions() {
		return qRepo.findAll();
	}
	
	public Question findById(Long id) {
		Optional<Question> optionalQuestion = qRepo.findById(id);
		if (optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
	public Question addQuestion(Question question) {
		return qRepo.save(question);
	}
}
