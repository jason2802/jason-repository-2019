package com.example.easynotes.aspect.user;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// @Before("execution(* com.example.easynotes.aspect.user.UserAccess.*.*(..))") NON VA BENE perchè il pointcut deve indicare tutti il path dovè si trovano i metodi sui cui applicare il joinpoint
	@Before("@annotation(com.example.easynotes.aspect.user.UserAccess)")	
	public void before(JoinPoint joinPoint) {
		logger.debug( " +++++ get Inside before getUserAccess  ");
		System.out.println(" +++++ hijacked : " + joinPoint.getSignature().getName() );
		logger.debug( " +++++ get Outside before getUserAccess  ");
	}	
}
