package com.example.easynotes.aspect;

import org.aspectj.lang.annotation.Pointcut;

/*
 * https://dzone.com/articles/implementing-aop-with-spring-boot-and-aspectj
 */

public class CommonJoinPointConfiguration {
	
	@Pointcut("execution(* com.example.easynotes.*.*())")
	public void timeTrackingExecution() {		
	}
}
