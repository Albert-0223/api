package com.ay.ayblog.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author : Albert Yang
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户登录密码
     */
    private String userPwd;

    /**
     * 用户状态
     */
    private String userStatus;

    /**
     * 用户性别
     */
    private String userGender;

    /**
     * 用户年龄
     */
    private Integer userAge;

    /**
     * 用户创建时间
     */
    private Date userCtime;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户最后登录时间
     */
    private Date userLastLogin;

}