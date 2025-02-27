package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeItAspect {

    private static final Logger logger = LoggerFactory.getLogger(TimeItAspect.class);

    @Pointcut("@annotation(aop.TimeIt)")
    public void timeItMethods() {}

    @Around("timeItMethods()")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() - start;

        logger.info("Method [{}] executed in {} ms", joinPoint.getSignature().toShortString(), elapsedTime);
        return result;
    }
}