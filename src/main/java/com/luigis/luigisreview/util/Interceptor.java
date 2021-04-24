package com.luigis.luigisreview.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Aspect
@Configuration
@Service
public class Interceptor {

    // Logger used to monitor application usage
    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    /**
     * This advice method execute before entering a controller, business service, or
     * data service method
     * 
     * @param joinPoint the execution instance of the advice for the pointcut
     */
    @Before("execution(* com.luigis.luigisreview.controllers.*.*(..)) || execution(* com.luigis.luigisreview.business.*.*(..)) || execution(* com.luigis.luigisreview.data.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // read method signature for inclusion in logs
        String signature = joinPoint.getSignature().toString();
        // log method entry
        logger.info("Entering " + signature.substring(signature.indexOf(" ") + 1));
    }

    /**
     * This advice method execute after a return statement in a controller, business
     * service, or data service method
     * 
     * @param joinPoint the execution instance of the advice for the pointcut
     * @param result    the return value
     */
    @AfterReturning(value = "execution(* com.luigis.luigisreview.controllers.*.*(..)) || execution(* com.luigis.luigisreview.business.*.*(..)) || execution(* com.luigis.luigisreview.data.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        // read method signature for inclusion in logs
        String signature = joinPoint.getSignature().toString();

        // if the method return value is not null
        if (result != null) {
            // log the happy path execution
            logger.info("Exiting " + signature.substring(signature.indexOf(" ") + 1) + " after successful execution");
        }

        else {
            // log the null return
            logger.warn("Exiting " + signature.substring(signature.indexOf(" ") + 1) + " with null");
        }
    }

    /**
     * This advice method execute after an exception is thrown in a controller,
     * business service, or data service method
     * 
     * @param joinPoint joinPoint the execution instance of the advice for the
     *                  pointcut
     * @param e         the exception thrown
     */
    @AfterThrowing(value = "execution(* com.luigis.luigisreview.controllers.*.*(..)) || execution(* com.luigis.luigisreview.business.*.*(..)) || execution(* com.luigis.luigisreview.data.*.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        // read method signature for inclusion in logs
        String signature = joinPoint.getSignature().toString();
        // log the exception
        logger.error("Exiting " + signature.substring(signature.indexOf(" ") + 1) + " with exception of type: "
                + e.getClass() + " and message: " + e.getMessage());
    }
}
