package com.tongfu.idoc.auth.aop;


import com.tongfu.idoc.auth.annotation.IdocActionLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @auther Deubugxiaowangzi
 * @date 2018/12/5 12:52
 */

@Component
@Aspect
@Slf4j
public class AopIdocActionLog {

    /**
     * 定义AOP扫描路径
     * 第一个注解只扫描aopTest方法
     */
    //@Pointcut("execution(public * com.aston.reader.controller.StudentController.aopTest())")


//    @Pointcut("@annotation(com.wds.order.annotation.IdocActionLog)")
//    public void log(){}
    @Before("@annotation(idocActionLog)")
    public void test(IdocActionLog idocActionLog) {
        try {
            // proceedingJoinPoint.proceed();
            int a = idocActionLog.type();

            System.err.println("Before....................." + a);
        } catch (Throwable e) {

        }
    }

    @After("@annotation(idocActionLog)")
    public void test2(IdocActionLog idocActionLog) {
        try {
            //proceedingJoinPoint.proceed();
            System.err.println("After.....................");
        } catch (Throwable e) {

        }
    }


}


