package com.tongfu.idoc.auth.filter;


import com.tongfu.idoc.auth.dataObject.User;
import com.tongfu.idoc.auth.utils.JsonUtils;
import com.tongfu.idoc.auth.utils.RedisClient;
import com.tongfu.idoc.auth.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * @auther Deubugxiaowangzi
 * @date 2018/12/12 19:34
 */
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class LoginFilter implements Filter {



    @Autowired
    private RedisClient redisClient ;

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/main/excludefilter", "/login", "/logout", "/register")));


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        // 处理响应乱码
//          response.setCharacterEncoding("UTF-8");
//          response.setContentType("text/html;charset=utf-8");
        if(allowedPath){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            String token=request.getHeader("token");
            User user= JsonUtils.string2Obj(redisClient.get(token),User.class );
            if(user==null){
                return ;
            }else{
                redisClient.expire(token, 30*60);
            }
            UserUtils.setUser(user);
            filterChain.doFilter(servletRequest,servletResponse);
        }
        UserUtils.cleanUser();
    }

    @Override public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override public void destroy() {

    }

    /**
     * @Author:
     * @Description: 是否需要过滤
     * @Date:
     * @param uri
     */

//    public boolean isNeedFilter(String uri) {
//        for (String includeUrl : includeUrls) {
//            if(includeUrl.equals(uri)) { return false; }
//        }
//        return true;
//    }





}
