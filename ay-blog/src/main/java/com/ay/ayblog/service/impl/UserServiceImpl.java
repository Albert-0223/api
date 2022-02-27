package com.ay.ayblog.service.impl;

import com.ay.ayblog.dao.UserMapper;
import com.ay.ayblog.pojo.User;
import com.ay.ayblog.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        setUserBaseInfo(user);
        userMapper.insert(user);
    }

    public void setUserBaseInfo(User user) {
        if (StringUtils.isEmpty(user.getUserGender())) {
            user.setUserGender("M");
        } else {
            user.setUserGender(user.getUserGender());
        }
        if (StringUtils.isEmpty(user.getUserEmail())) {
            user.setUserEmail("Initialize@mailbox.com");
        } else {
            user.setUserEmail(user.getUserEmail());
        }
        if (user.getUserAge() == null) {
            user.setUserAge(0);
        } else {
            user.setUserAge(user.getUserAge());
        }

        user.setUserCtime(new Date());
        user.setUserStatus("A");
        user.setUserLastLogin(new Date());
    }

    @Override
    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }

    @Override
    public void deleteUserByIds(List<Integer> userIds) {
        userMapper.deleteUserByIds(userIds);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserByIds(List<Integer> userIds) {
        return userMapper.getUserByIds(userIds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userMapper.getAllByUsers();
    }

    @Override
    public void markUserDirty(Integer userId) {
        userMapper.updateUserDirty(userId);
    }

    @Override
    public void markUsersDirty(List<Integer> userIds) {
        userMapper.updateUsersDirty(userIds);
    }

    @Override
    public void updateUserPwdById(Integer userId, String userPwd) {
        userMapper.updateUserPwdById(userId, userPwd);
    }

    @Override
    public void updateUserInfoById(Integer userId, String userName, String userEmail, Integer userAge, String userGender) {
        userMapper.updateUserInfoById(userId, userName, userEmail, userAge, userGender);
    }

    @Override
    public void updateUserLastLoginTime(Integer userId, Date date) {
        userMapper.updateUserLastLoginTime(userId, date);
    }
}
