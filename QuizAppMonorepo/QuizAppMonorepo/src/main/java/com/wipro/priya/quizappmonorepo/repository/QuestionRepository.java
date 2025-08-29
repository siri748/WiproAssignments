package com.wipro.priya.quizappmonorepo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.priya.quizappmonorepo.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

	
	@Query(value = "SELECT * FROM question q WHERE q.category = :category AND q.difficulty= :difficult ORDER BY RAND() LIMIT 3", nativeQuery = true)

	 List<Question> findRandomQuestionByCategoryAndLevel(String category,String difficult) ;

	 Question getQuestionById(Long id);

		
		
	

}
