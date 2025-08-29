package com.wipro.priya.quizappmonorepo.excep;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ErrorMessage>handleUserNotFoundException(Question_Not_Found ex){
		ErrorMessage error=new ErrorMessage(ex.getMessage(),"User_not_Found");
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
