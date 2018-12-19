package com.tongfu.idoc.auth.dataObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


/**
 * @auther Deubugxiaowangzi
 * @date 2018/12/11 14:51
 */
public class User {

    private Long id;
    private  String userCode;//用户账号
    @JsonIgnore
    private String passWord;//密码
    private String userName;//姓名
//  区分用户以什么方式登陆
    private  String LoginType ;

    public  User() {


    }

    public User(String userCode) {
        this.userCode = userCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginType() {
        return LoginType;
    }

    public void setLoginType(String loginType) {
        LoginType = loginType;
    }

    public User(Long id, String userCode, String passWord, String userName, String loginType) {
        this.id = id;
        this.userCode = userCode;
        this.passWord = passWord;
        this.userName = userName;
        LoginType = loginType;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", passWord='" + passWord + '\'' +
                ", userName='" + userName + '\'' +
                ", LoginType='" + LoginType + '\'' +
                '}';
    }
}
