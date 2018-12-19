package com.tongfu.idoc.auth.mapper;

import com.tongfu.idoc.auth.dataObject.User;

/**
 * @Author: Sijie Zhi
 * @Date: 2018/12/18 18:17
 */
public interface UserMapper {
    public User doLogin(User user);
}
