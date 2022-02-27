package com.ay.ayblog.service;

import com.ay.ayblog.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface UserService {

    void insert(User user);

    void deleteUserById(Integer userId);

    void deleteUserByIds(List<Integer> userIds);

    @Transactional(readOnly = true)
    User getUserByName(String userName);

    @Transactional(readOnly = true)
    User getUserById(Integer userId);

    @Transactional(readOnly = true)
    List<User> getUserByIds(List<Integer> userIds);

    @Transactional(readOnly = true)
    List<User> getAllUsers();

    void markUserDirty(Integer userId);

    void markUsersDirty(List<Integer> userIds);

    void updateUserPwdById(Integer userId, String userPwd);

    void updateUserInfoById(Integer userId, String userName, String userEmail, Integer userAge, String userGender);

    void updateUserLastLoginTime(Integer userId, Date date);
}
