package com.wipro.priya.quizappmonorepo.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.priya.quizappmonorepo.entities.Question;
import com.wipro.priya.quizappmonorepo.excep.Question_Not_Found;
import com.wipro.priya.quizappmonorepo.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService{
 
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question save(Question question) {
		
		return questionRepository.save(question);
	}
	@Override
	public Question getQuestionById(Long id) {
		
		return questionRepository.getQuestionById(id);
	}

	@Override
	public List<Question> findAllQuestion() {
		
		return questionRepository.findAll();
	}
	
	@Override
	public void deletQuestion(Long id) {
		questionRepository.deleteById(id);
		
	}
	@Override
	public Question updateQuestionById(Long id, Question question) {
	Question existingQuestion=questionRepository.findById(id)
			                                    .orElseThrow(()-> new Question_Not_Found("Question with Id is not present: "+id));
		
	if(question.getQuestionTitle()!=null) {
		existingQuestion.setQuestionTitle(question.getQuestionTitle());
	}
	if(question.getOption1()!=null) {
		existingQuestion.setOption1(question.getOption1());
	}if(question.getOption2()!=null) {
		existingQuestion.setOption2(question.getOption2());
	}if(question.getOption3()!=null) {
		existingQuestion.setOption3(question.getOption3());
	}if(question.getOption4()!=null) {
		existingQuestion.setOption4(question.getOption4());
	}if(question.getDifficulty()!=null) {
		existingQuestion.setDifficulty((question.getDifficulty()));
	}
	if(question.getCategory()!=null) {
		existingQuestion.setCategory((question.getCategory()));
	}
	
	return questionRepository.save(existingQuestion);
	}

	
	}
