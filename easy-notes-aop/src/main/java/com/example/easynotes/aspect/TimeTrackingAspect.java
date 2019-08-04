package com.example.easynotes.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


/*
 * https://dzone.com/articles/implementing-aop-with-spring-boot-and-aspectj
 */

@Aspect
@Configuration
public class TimeTrackingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	// @Around("@annotation(com.example.easynotes.aspect.TimeTracking)")
	@Around("(com.example.easynotes.aspect.CommonJoinPointConfiguration.timeTrackingExecution())")
	public void around(ProceedingJoinPoint joinPoint ) throws Throwable {
		logger.debug( " ---------- Inside around ------------ ");
		long startTime = System.currentTimeMillis();
		
		joinPoint.proceed();
		
		long timeTaking = System.currentTimeMillis() - startTime;
		logger.debug( " Time taken by {} is {} ", joinPoint, timeTaking );				
	}
}

/*
 
Notes:

@Around uses an around advice. It intercepts the method call and uses joinPoint.proceed() to execute the method.
@annotation(com.in28minutes.springboot.tutorial.basics.example.aop.TrackTime) is the pointcut to define interception based on an annotation — @annotation followed by the complete type name of the annotation.
Once we define the annotation and the advice, we can use the annotation on methods that we would want to track, as shown below:

*/