package com.practice.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	// Business, Data, Controller 계층으로 나눠져 있지만 공통적으로 수행해야하는 부분이 있을 것 이다.
	// 대표적으로는 보안, 성능, 로깅이 있다. 이것을 공통 관심사라고 하며 Layer는 다르지만 공통으로 수행될 부분에 대한 시스템을 구축하는 것을 AOP 라고 한다.
	// Logging 관점은 크게 언제, 무엇을 로깅할 것인지에 대해서 명시 해야 하는데
	// @Before 어노테이션으로 해당 패키지의 모든 메서드를 프로그램이 실행되기 전에 인터셉트해서 
	// JopPoint를 이용해서 로그를 가져온다. 
	@Before("execution(* com.practice.learnspringaop.aopexample.*.*.*(..))")
	public void logMethodCall(JoinPoint joinPoint) {
		logger.info("Before Aspect - {} is called with arguments: {}"
				,  joinPoint, joinPoint.getArgs());
	}
	
	@After("execution(* com.practice.learnspringaop.aopexample.*.*.*(..))")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has executed",  joinPoint);
	}

	@AfterThrowing(
	pointcut = "execution(* com.practice.learnspringaop.aopexample.*.*.*(..))",
	throwing = "exception"
	)
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} has thrown an exception {}"
				,  joinPoint, exception);
	}

	@AfterReturning(
	pointcut = "execution(* com.practice.learnspringaop.aopexample.*.*.*(..))",
	returning = "resultValue"
	)
	public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, 
			Object resultValue) {
		logger.info("AfterReturning Aspect - {} has returned {}"
				,  joinPoint, resultValue);
	}

}