package com.wipro.priya.quizappmonorepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.priya.quizappmonorepo.entities.Question;
import com.wipro.priya.quizappmonorepo.services.QuestionService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/question")
public class QuestionController {
	@Autowired
	private final QuestionService questionService;
	
	
	@PostMapping("/addQuestion")
	public Question addQuestion(@RequestBody Question question) {
		return questionService.save(question);
	}
	
	
	@GetMapping("/getQuestionById/{id}")
	public Question getQuestionById(@PathVariable Long id) {
		return questionService.getQuestionById(id);
	}
	@GetMapping("/getAllQuestions")
	public List<Question> getAllQuestions(){
		
		return questionService.findAllQuestion();
	}
	
	@PutMapping("/updateQuestion/{id}")
	public Question updateQuestionById(@PathVariable Long id,@RequestBody Question question) {
		return questionService.updateQuestionById(id,question);
	}
	
	@DeleteMapping("/deleteQuestion/{id}")
	public void deleteQuestion(@PathVariable Long id) {
		questionService.deletQuestion(id);
	}
	

}
