package com.tongfu.idoc.auth.service.Impl;

import com.tongfu.idoc.auth.dataObject.User;
import com.tongfu.idoc.auth.mapper.UserMapper;
import com.tongfu.idoc.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 业务层
 * @Author: Sijie Zhi
 * @Date: 2018/12/18 18:19
 */
@Component
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * 获取登录用户
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public User doLogin(User user) throws Exception {
        return userMapper.doLogin(user);
    }
}
