package com.example.customerman.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MainControllerAOP {

    private static int numble;

    @After(" execution(* com.example.customerman.controller.MainController.listCustomers(..))")
    public void showAction(JoinPoint joinPoint) {
        numble++;
        System.out.println("Hiển thị list " + numble + " lần.");
    }


    @After(" execution(* com.example.customerman.controller.MainController.*(..))")
    public void checkDone(JoinPoint joinPoint) {
        numble++;
        System.out.println("kiểm tra phương thức trueyèn vào tất cả");
    }
}
