package com.lynda.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

@Component
@Aspect
public class LogingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogingAspect.class);

    @Pointcut("@annotation(Loggable)")
    public void executeLogging(){
    }


/*
   @Before("executeLogging()")
    public void loggMethpdCallBefore(JoinPoint joinPoint){
        StringBuilder message = new StringBuilder("Method: ");
        message.append(joinPoint.getSignature().getName());
        Object[] methodArgs = joinPoint.getArgs();
        if(methodArgs != null && methodArgs.length >0){
            message.append("args=[");
            Arrays.asList(methodArgs).forEach(arg->{
                message.append("arg=").append(arg).append("|");
            });
        }
        LOGGER.info(message.toString());
    }
    @AfterReturning(pointcut="executeLogging()",returning = "returnValue")
    public void loggMethpdCallAfterReturning(JoinPoint joinPoint,Object returnValue){
        StringBuilder message = new StringBuilder("Method: ");
        if(returnValue instanceof Collection){
            message.append("returinig : ").append(((Collection) returnValue).size()).append(" instance(s)");
        }else {
            message.append(" Returning : ").append(returnValue.toString());
        }
        LOGGER.info(message.toString());
    }

    @AfterThrowing(pointcut="executeLogging()",throwing = "error")
    public void loggMethpdCallAfterThrowing(JoinPoint joinPoint,Throwable error){
        StringBuilder message = new StringBuilder("Method: ");
        message.append("Method name: ").append(joinPoint.getSignature().getName());
        message.append("exception :").append(error.getMessage());
        LOGGER.info(message.toString());
    }
*/


   @Around("executeLogging()")
    public Object logMethodCallAround(ProceedingJoinPoint proceedingJoinPoint){
        StringBuilder BeforeMessage = new StringBuilder("Method: ");
        String methodName = proceedingJoinPoint.getSignature().getName();
        BeforeMessage.append("Before invoking  Method Name: ").append(methodName).append( "---> Arguments");
        Object[] methodArgs = proceedingJoinPoint.getArgs();
        if(methodArgs != null && methodArgs.length >0){
            BeforeMessage.append("args=[");
            Arrays.asList(methodArgs).forEach(arg->{
                BeforeMessage.append("arg=").append(arg).append("|");
            });
        }
        LOGGER.info(BeforeMessage.toString());


        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            StringBuilder errorMessage = new StringBuilder(proceedingJoinPoint.getSignature().getDeclaringType().getName()).append(":::").append(proceedingJoinPoint.getSignature().getName());
            errorMessage.append("-->> Cause : ").append(e.getCause());
            errorMessage.append("-->> Message : ").append(e.getMessage());
            LOGGER.error(errorMessage.toString(),e);
        }
        StringBuilder afterMessage = new StringBuilder("After invoking  Method Name : ").append(methodName);
        afterMessage.append("Response Data : ").append("value");
        System.out.println("After invoking getName() method. Return value="+value);
        if(value instanceof Collection){
            afterMessage.append("returinig : ").append(((Collection) value).size()).append(" instance(s)");
        }else {
            afterMessage.append(" Returning : ").append(value);
        }
        LOGGER.info(afterMessage.toString());
        return value;
    }
}
