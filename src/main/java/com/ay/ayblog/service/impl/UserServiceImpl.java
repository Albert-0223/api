package com.ay.ayblog.service.impl;

import com.ay.ayblog.dao.UserMapper;
import com.ay.ayblog.pojo.User;
import com.ay.ayblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
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
        return userMapper.getUserbyName(userName);
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
