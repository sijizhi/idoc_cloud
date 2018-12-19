package com.tongfu.idoc.power.utils;


import com.tongfu.idoc.power.dataObject.User;

/**
 * @auther Deubugxiaowangzi
 * @date 2018/12/12 19:31
 */
public class UserUtils {

    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public static User getUser(){
        return threadLocal.get();
    }
    public static void setUser(User user){
        threadLocal.set(user);
    }
    public static void cleanUser(){
        threadLocal.remove();
    }
}
