package com.wipro.priya.quizappmonorepo.services;



import java.util.List;

import com.wipro.priya.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.priya.quizappmonorepo.entities.Quiz;
import com.wipro.priya.quizappmonorepo.entities.Response;


public interface QuizService  {

	 Quiz createQuiz(String category, String level, String title);

	 List<QuestionWrapper> getQuizQuestions(Integer id);

	 Integer calculateResult(int id, List<Response> response);
		

	
}
