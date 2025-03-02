package com.snosack.dojooverflow.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.snosack.dojooverflow.models.Answer;
import com.snosack.dojooverflow.models.Question;
import com.snosack.dojooverflow.models.Tag;
import com.snosack.dojooverflow.services.AnswerService;
import com.snosack.dojooverflow.services.QuestionService;
import com.snosack.dojooverflow.services.TagService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private QuestionService qServ;
	
	@Autowired
	private AnswerService aServ;
	
	@Autowired
	private TagService tServ;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", qServ.allQuestions());
		return "index.jsp";
	}
	
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String addQuestion(@Valid @ModelAttribute("question")
	Question question, BindingResult result, 
	@RequestParam("listOfTags") String listOfTags,
	RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "newQuestion.jsp";
		}
		List<Tag> questionTags = checkTags(listOfTags);
		
		if(questionTags == null || questionTags.size() > 3) {
			redirectAttributes.addFlashAttribute("error", "The number of tags must be between 1 and 3.");
			return "redirect:/questions/new";
		}
		
		question.setTags(questionTags);
		qServ.addQuestion(question);
		
		return "redirect:/";
	}
	
	private List<Tag> checkTags(String tags) {
		if(tags.length()>0) {
			ArrayList<Tag> questionTags = new ArrayList<Tag>();
			String[] tagList = tags.split(",");
			for(String tagString:tagList) {
				Tag tag = tServ.findBySubject(tagString.toLowerCase().strip());
				if(tag == null) {
					tag = new Tag(tagString.toLowerCase().strip());
					tServ.addTag(tag);
				}
				questionTags.add(tag);
			}
			return questionTags;
		}
		return null;
	}
	
	@GetMapping("/questions/{id}")
	public String viewQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answer") Answer answer) {
		model.addAttribute("question", qServ.findById(id));
		return "viewQuestion.jsp";
	}
	
	@PostMapping("/questions/{questionId}/answers/new")
	public String newAnswer(@Valid @ModelAttribute("answer") Answer answer,
			BindingResult result, @PathVariable("questionId") Long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("question", qServ.findById(id));
			return "viewQuestion.jsp";
		}
		
		answer.setQuestion(qServ.findById(id));
		aServ.addAnswer(answer);
		
		return "redirect:/questions/" + id;
	}

}