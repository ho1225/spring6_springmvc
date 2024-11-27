package com.schh.spring6.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//切面類
@Aspect //切面類
@Component // add to ioc container
public class LogAspect {

    //set 切入點和通知TYPE
    //通知TYPE: Before, AfterReturning, AfterThrowing, After, Around

    //@Before
//    @Before(value = "execution(* com.schh.spring6.aop.annoaop.CalculatorImpl.*(..))")
    @Before(value = "execution(public int com.schh.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger-->before advice , method Name: "+methodName+ ", arguments:" + Arrays.toString(args));
    }


    // @After()
    @After(value = "execution(* com.schh.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->after advice , method Name: "+methodName);
    }


    //@AfterReturning()
    @AfterReturning(value = "execution(* com.schh.spring6.aop.annoaop.CalculatorImpl.*(..))", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->after returning advice , method Name: "+methodName+", returning result: " +result);
    }

    //@AfterThrowing()
    //execute when there is error in the method
    @AfterThrowing(value = "execution(* com.schh.spring6.aop.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->after throwing advice , method Name: "+methodName+ "error msg: "+ex);
    }

    //@Around()

    @Around("execution(* com.schh.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argString = Arrays.toString(args);
        Object result = null;
        try {
            System.out.println("around advice==before method execute");

            //execute method
            result = joinPoint.proceed();

            System.out.println("around advice==after returning method execute");
        } catch (Throwable throwable){
            throwable.printStackTrace();
            System.out.println("around advice==after throwing exception");
        }finally {
            System.out.println("around advice==after method execute");
        }
        return result;
    }

}
