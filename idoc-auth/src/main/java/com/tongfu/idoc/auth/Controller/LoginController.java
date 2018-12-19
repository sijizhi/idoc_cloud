package com.tongfu.idoc.auth.Controller;


import com.tongfu.idoc.auth.dataObject.User;
import com.tongfu.idoc.auth.service.UserService;
import com.tongfu.idoc.auth.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @auther Deubugxiaowangzi
 * @date 2018/12/11 9:59
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private RedisClient redisClient ;

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    /**
     * 测试文件权限
     * @param docId
     * @return
     * @throws Exception
     */
    @RequestMapping("/idoc_power")
    public ResultData test(int docId) throws  Exception{
        if(UserUtils.getUser().getId()==docId){
            return new ResultData(200, "已授权");
        }
         return new ResultData(550, "未授权");
    }

    /**
     * 用户登录
     * @param userCode
     * @param passWord
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/login")
    public Object login(String userCode , String  passWord, HttpServletResponse httpResponse) throws Exception{
        User user=new User(userCode);
        user=userService.doLogin(user);
        Map<String,Object> map;
        if(user!=null){
            if(passwordEncoder.matches(passWord,user.getPassWord())){
                map=new HashMap<>();
                map.put("userName", user.getUserName());
                String uuid=UUID.randomUUID().toString();
                redisClient.set("token:"+uuid, JsonUtils.obj2String(user),60*30);//30分钟
                CookieUtil.set(httpResponse, "idoctoken", "token:"+uuid, 60*30);
                return  new ResultData(200,"登录成功",map);
            }
            return new ResultData(401,"密码有误");
        }else {
            return new ResultData(401,"账号或密码有误");
        }
    }

    /**
     * 用户退出
     * @param token
     * @return
     */
    @PostMapping("/logout")
    public ResultData logout(String token){
        redisClient.delete(token);
        return  new ResultData(200,"退出成功");
    }




}
