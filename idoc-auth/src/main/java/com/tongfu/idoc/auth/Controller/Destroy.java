package com.tongfu.idoc.auth.Controller;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * @auther Deubugxiaowangzi
 * @date 2018/12/10 17:38
 */

@Component
public class Destroy  implements DisposableBean, ExitCodeGenerator {


    public Destroy(){
       // System.out.println("构造函数！！！！");

    }

    @Override

    public void destroy() throws Exception {
     // System.out.println("destroy！！！！！！！！！！！！！！！！");
    }


    public void afterPropertiesSet() throws Exception {
       // System.out.println("afterPropertiesSet！！！！！！！！！！！！！！！！！！");
    }

    @Override
    public int getExitCode() {
        return 5;
    }
}
