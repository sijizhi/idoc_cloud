package com.tongfu.idoc.file.interceptor;



import com.tongfu.idoc.file.dataObject.User;
import com.tongfu.idoc.file.utils.JsonUtils;
import com.tongfu.idoc.file.utils.RedisClient;
import com.tongfu.idoc.file.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 21:16
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisClient redisClient;

    //进入ctroller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //一般判断tocken，不符合就直接response重定向等
        String token=request.getHeader("token");
        System.out.println("===============preHandle1==============");
        if(token!=null){
            User user= JsonUtils.string2Obj(redisClient.get(token),User.class);
            if(user!=null){
                UserUtils.setUser(user);
                return HandlerInterceptor.super.preHandle(request, response,handler );//放行
            }
            System.out.println("token校验不通过1");
            return false;
        }
        return false;

    }
    // 调用controller之后，页面渲染前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========postHandle1============");
        HandlerInterceptor.super.postHandle(request,response ,handler ,modelAndView );
    }
    //全部结束后，常用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========afterCompletion1============");
        HandlerInterceptor.super.afterCompletion(request,response ,handler ,ex );
    }
}
