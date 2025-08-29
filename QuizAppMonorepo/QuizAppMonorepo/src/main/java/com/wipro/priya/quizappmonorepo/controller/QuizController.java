package com.wipro.priya.quizappmonorepo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.priya.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.priya.quizappmonorepo.entities.Quiz;
import com.wipro.priya.quizappmonorepo.entities.Response;
import com.wipro.priya.quizappmonorepo.services.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/quiz")
public class QuizController {
	@Autowired
	private final QuizService quizService;
	
	@PostMapping("/createQuiz")
	public Quiz createQuiz(@RequestParam String category,@RequestParam String level, @RequestParam String title) {
		return quizService.createQuiz(category,level,title);
	}
	
	@GetMapping("/getQuizById/{id}")
	public List<QuestionWrapper> getQuizQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submitQuiz/{id}")
	public Integer submitQuiz(@PathVariable int id,@RequestBody List<Response>  responses) {
		return quizService.calculateResult(id,responses);
	}

}
