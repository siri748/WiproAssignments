package com.wipro.priya.quizappmonorepo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



import lombok.extern.slf4j.Slf4j;

@Aspect    // telling to spring this is the extra logic i am writting
@Component //asking spring to  take care of this class(object creation)
@Slf4j
public class LoggingAspect {
	
	//this is method
	@Before("execution(*com.wipro.archana.quizappmonorepo.controller.QuestionController.addQuestion(..))")
	public void logbefore(JoinPoint joinpoint) {
		 log.error("loging something before addQuestion Endpont");
		 log.error("which method we are calling! {}",joinpoint.getSignature().getName());
		 log.error("loging something before addQuestion Endpont");
    }
	
	

}

