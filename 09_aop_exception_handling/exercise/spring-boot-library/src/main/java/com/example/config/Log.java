package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Log {

    @Pointcut("execution(* com.example.controller.BookController.*(..))")
    public void allBodyViewPage(){}

    @Before("allBodyViewPage()")
    public void beforBodyViewPage(JoinPoint joinPoint){
        System.out.println("METHOD NAME :" +
                joinPoint.getSignature().getName() +
                "Time" + LocalDateTime.now());
    }


    @Pointcut("execution(* com.example.controller.BookController.update*(..))")
    public void allMethodUpdate(){}

    @Before("allMethodUpdate()")
    public void beforeMethodUpdate(JoinPoint joinPoint){
        System.out.println("START METHOD NAME: "+
              joinPoint.getSignature().getName() +"Time Update Book: "+
                LocalDateTime.now());
    }

    @AfterReturning("allMethodUpdate()")
    public void afterThrowingMethodUpdate(JoinPoint joinPoint){
        System.out.println("END METHOD NAME: "+
                joinPoint.getSignature().getName() +"Time Update Book: "+
                LocalDateTime.now());
    }
}
