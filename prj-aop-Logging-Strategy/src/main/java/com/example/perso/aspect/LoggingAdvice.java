package com.example.perso.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {
	
	Logger LOG = LoggerFactory.getLogger( LoggingAdvice.class );
		
	// @Around(execution("* com.example.perso.*.*(..)"))
	@Around("@annotation(com.example.perso.aspect.Logging)")	
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		
		Object[] array = pjp.getArgs();
		LOG.info( " - method invoked: " + className + " : " + methodName + "( )" + " - Input Arguments : " + mapper.writeValueAsString( array ));
		
		Object object = pjp.proceed();
		
		LOG.info( " - method executed: " + className + " : " + methodName + "( )" + " - Response : " + mapper.writeValueAsString( array ));
		
		return object;
	} 

}
