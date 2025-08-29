package com.wipro.priya.quizappmonorepo.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.priya.quizappmonorepo.entities.Question;
import com.wipro.priya.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.priya.quizappmonorepo.entities.Quiz;
import com.wipro.priya.quizappmonorepo.entities.Response;
import com.wipro.priya.quizappmonorepo.repository.QuestionRepository;
import com.wipro.priya.quizappmonorepo.repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Quiz createQuiz(String category, String level, String title) {
		List<Question> questions=questionRepository.findRandomQuestionByCategoryAndLevel(category,level);
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		return quizRepository.save(quiz);
	}
	

	@Override
	public List<QuestionWrapper> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizRepository.findById(id);
        
        
	       List<Question> questionsFromDB = quiz.get().getQuestions();
	       
	        List<QuestionWrapper> questionsForUser = new ArrayList<>();
	        for(Question q : questionsFromDB){
	            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
	            questionsForUser.add(qw);
	        }

	        return questionsForUser;

	    }
	
//		Quiz quiz = quizRepository.findById(id).orElseThrow(()->new RuntimeException("Quiz with ID " + id + " not found"));
//        
//        
//	       List<Question> questionsFromDB = quiz.getQuestions();
//	       
//	        List<QuestionWrapper> questionsForUser = new ArrayList<>();
//	        for(Question q : questionsFromDB){
//	            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
//	            questionsForUser.add(qw);
//	        }
//
//	        return questionsForUser;
//	}

	@Override
	public Integer calculateResult(int id, List<Response> responses) {
	Quiz quiz =quizRepository.findById(id).get();
	List<Question> questions=quiz.getQuestions();
	int rightAnswerScore=0;
	
	for(Response response : responses) {
		for(Question question:questions) {
			if(question.getId()==response.getId()) {
				if(question.getCorrectAnswer().equalsIgnoreCase(response.getResponse())) {
					rightAnswerScore++;
				}
				break;
			}
			
		}
		
	}
		return rightAnswerScore;
	}

}
