package it.eng.petarrelic.vezba.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
@Component
public class LoggingInterceptor {

	@Before(value = "@annotation(it.eng.petarrelic.vezba.logging.Loggable)")
    public void beforeMethodExectuion(JoinPoint joinPoint) {

        LoggerFactory.getLogger(joinPoint.getTarget().getClass()).info("Method-[{}] Input-{}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(value = "@annotation(it.eng.petarrelic.vezba.logging.Loggable)", returning = "returnValue")
    public void afterMethodExectuion(JoinPoint joinPoint, Object returnValue) {

        LoggerFactory.getLogger(joinPoint.getTarget().getClass()).info("Method-[{}] Input-{} Return-[{}]", joinPoint.getSignature(), joinPoint.getArgs(), returnValue);
    }

    @AfterThrowing(pointcut = "@annotation(it.eng.petarrelic.vezba.logging.Loggable)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex) {

        LoggerFactory.getLogger(joinPoint.getTarget().getClass()).error("Method-[{}] Input-{} ERROR: {}", joinPoint.getSignature(), joinPoint.getArgs(), ex.getMessage());
    }
	
}
