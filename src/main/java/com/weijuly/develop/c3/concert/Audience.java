package com.weijuly.develop.c3.concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(** com.weijuly.develop.c3.concert.Performance.perform(..))")
	public void performance() {
	}

	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint point) {
		System.out.println("Silencing all phones");
		System.out.println("Taking Seats");
		try {
			point.proceed();
			System.out.println("Clapping...");
		} catch (Throwable ex) {
			System.out.println("Demanding refund !");
		} finally {
			System.out.println("Returning home");
		}
	}
}
