package com.ddominguezh.superhero.shared.domain.config.handler;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceableHandler {

	private static Logger logger = Logger.getLogger(TraceableHandler.class);
	private Instant start;
	
	@Before("execution(* com.ddominguezh.superhero.app.*.infrastructure.controller.*.*(..))")
	public void initExecuteController(JoinPoint joinPoint) {
		this.start = Instant.now();
		logger.info("Start: " + joinPoint.getSignature().getName() + ".");
	}
	
	@After("execution(* com.ddominguezh.superhero.app.*.infrastructure.controller.*.*(..))")
	public void endContorller(JoinPoint joinPoint) {
		logger.info("End: " + joinPoint.getSignature().getName() + ". Duration: " + ChronoUnit.SECONDS.between(start, Instant.now())  + " seconds");
	}
}
