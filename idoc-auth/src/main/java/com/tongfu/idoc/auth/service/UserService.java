package com.tongfu.idoc.auth.service;

import com.tongfu.idoc.auth.dataObject.User;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/18 18:19
 */
public interface UserService {
    public User doLogin(User user) throws  Exception;
}
