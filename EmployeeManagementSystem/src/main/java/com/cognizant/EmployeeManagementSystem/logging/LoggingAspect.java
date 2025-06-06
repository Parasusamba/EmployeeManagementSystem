package com.cognizant.EmployeeManagementSystem.logging;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	@Before("execution(public * com.cognizant.EmployeeManagementSystem.service.EmployeeService.findAll())")
	public void logBefore() {
		LOGGER.info("findAll method called..");
	}
	@AfterReturning("execution(public * com.cognizant.EmployeeManagementSystem.service.EmployeeService.findAll())")
	public void logAfter() {
		LOGGER.info("findAll method executed.");
	}
	@AfterThrowing("execution(public * com.cognizant.EmployeeManagementSystem.service.EmployeeService.findAll())")
	public void logException() {
		LOGGER.info("Exception occurred");
	}
}
