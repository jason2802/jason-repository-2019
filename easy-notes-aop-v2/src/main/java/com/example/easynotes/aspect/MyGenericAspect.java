package com.example.easynotes.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MyGenericAspect {

	private static Logger logger = LoggerFactory.getLogger( MyGenericAspect.class );
			
	@AfterReturning(value = "execution(* com.example.easynotes.*.*(..))", 
			returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info(" $$$$$$ {} returned with value {}", joinPoint, result);
	}
	
	@After(value = "execution(* com.example.easynotes..*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info(" !!!!!! after execution of {}", joinPoint);
	}
	
}
