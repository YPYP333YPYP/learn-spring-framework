package com.practice.learnspringaop.aopexample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// 해당 Aspect은 메소드가 실행되기 전에 시간을 재고 메소드가 실행된 후에 시간을 재서 메서드가 실행되는데 걸리는 시간을 측정하는
// 퍼포먼스 관련 Aspect이다. 여기서도 PointCut 개념에서 사용되는 어노테이션이 있는데 바로 @Around 어노테이션이다.
// PreoceedingJoinPoint 어노테이션을 이용하여 메서드를 미리 가져올 수 있다. 
@Aspect
@Configuration
public class PerformanceTrackingAspect {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//@Around("execution(* com.practice.learnspringaop.aopexample.*.*.*(..))")
	@Around("com.practice.learnspringaop.aopexample.aspects.CommonPointcutConfig.trackTimeAnnotation()")
	public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		long startTimeMillis = System.currentTimeMillis();
		
		Object returnValue = proceedingJoinPoint.proceed();
		
		long stopTimeMillis = System.currentTimeMillis();
		
		long executionDuration = stopTimeMillis - startTimeMillis;
		
		logger.info("Around Aspect - {} Method executed in {} ms"
				,proceedingJoinPoint, executionDuration);
		
		return returnValue;
	}

}