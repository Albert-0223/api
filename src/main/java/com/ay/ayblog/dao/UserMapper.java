package com.ay.ayblog.dao;

import com.ay.ayblog.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserMapper {
    /**
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * @param userId
     * @return
     */
    User getUserById(Integer userId);

    /**
     * @return
     */
    List<User> getAllByUsers();

    /**
     * @param userIds
     * @return
     */
    List<User> getUserByIds(List<Integer> userIds);

    /**
     * @param Name
     * @return
     */
    User getUserbyName(String Name);

    /**
     * @param user
     * @return
     */
    int updateUserById(User user);

    /**
     * @param userId
     */
    void updateUserDirty(Integer userId);

    /**
     * @param userIds
     */
    void updateUsersDirty(List<Integer> userIds);

    /**
     * @param userId
     * @param userName
     * @param userEmail
     * @param userAge
     * @param userGender
     */
    void updateUserInfoById(Integer userId, String userName, String userEmail, Integer userAge, String userGender);

    /**
     * @param userPwd
     */
    void updateUserPwdById(Integer userId, String userPwd);

    void updateUserLastLoginTime(Integer userId, Date date);

    /**
     * @param userId
     * @return
     */
    int deleteUserById(Integer userId);

    /**
     * @param userIds
     */
    void deleteUserByIds(List<Integer> userIds);
}