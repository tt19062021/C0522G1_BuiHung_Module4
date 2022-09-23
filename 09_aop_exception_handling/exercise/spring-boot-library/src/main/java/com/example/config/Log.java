package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class Log {
    private int count = 0;

    @Pointcut("execution(* com.example.controller.BookController.*(..))")
    public void allBodyViewPage(){}

    @AfterReturning("allBodyViewPage()")
    public void afterBodyViewPage(JoinPoint joinPoint){
            count++;
        System.out.println("METHOD NAME :" +
                joinPoint.getSignature().getName() +
                "Time " + LocalDateTime.now() +
                " Count Number View Page :" + count);
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
