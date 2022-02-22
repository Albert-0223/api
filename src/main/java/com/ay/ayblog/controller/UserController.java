package com.ay.ayblog.controller;

import com.ay.ayblog.pojo.Result;
import com.ay.ayblog.pojo.User;
import com.ay.ayblog.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户登录")
    @GetMapping("/login")
    public Result<Object> login(@RequestParam("name") String userName, @RequestParam("pwd") String userPwd) {
        log.info("userName : {} , userPwd : {}", userName, userPwd);
        Result<Object> result = new Result<>();
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(userPwd)) {
            result.setResultFailed("User name and password cannot be empty");
        }
        User currentDbUser = userService.getUserByName(userName);
        if (currentDbUser == null) {
            result.setResultFailed("User does not exist, please register first");
            return result;
        }
        if (!StringUtils.equals(currentDbUser.getUserName(), userName)
                || !StringUtils.equals(currentDbUser.getUserPwd(), userPwd)) {
            result.setResultFailed("User name or password input error");
            return result;
        }

        userService.updateUserLastLoginTime(currentDbUser.getUserId(), new Date());
        result.setResultSuccess("User login successful", currentDbUser);
        log.info("user : {} login successful", userName);
        return result;
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public Result<Object> createUser(User user) {
        log.info("user is : {}", user.toString());
        Result<Object> result = new Result<>();
        //Judge whether the user exists according to userName
        if (validateUserIsExist(user.getUserName())) {
            result.setResultFailed("User already exists, userName is : " + user.getUserName());
            return result;
        }
        setUserBaseInfo(user);
        userService.insert(user);
        //Judge whether the user has successfully inserted into database
        User dbUser = userService.getUserById(user.getUserId());
        if (dbUser == null) {
            result.setResultFailed("Failed to insert user into database");
            return result;
        }
        result.setResultSuccess("User register successfully", user);
        log.info("UserId : {} insert successfully", user.getUserId());
        return result;
    }

    @ApiOperation("逻辑删除用户")
    @DeleteMapping("/delete")
    public Result<Object> removeUser(@RequestParam("id") Integer userId) {
        log.info("userId : {}", userId);
        log.info("Start deleting user");
        Result<Object> result = new Result<>();
        userService.markUserDirty(userId);
        log.info("Delete user end");
        if (validateUserStatusIsD(userId)) {
            result.setResultSuccess("Batch delete user succeeded", null);
        } else {
            result.setResultFailed("");
        }
        return result;
    }

    @ApiOperation("批量逻辑删除用户")
    @DeleteMapping("/deleteBatch")
    public Result<Object> removeUsers(@RequestParam("ids") List<Integer> userIds) {
        log.info("userIds : {}", userIds.toString());
        log.info("Start deleting users");
        Result<Object> result = new Result<>();
        userService.markUsersDirty(userIds);
        log.info("Delete user end");
        List<User> deletedUsers = userService.getUserByIds(userIds);
        result.setResultSuccess("Batch delete user succeeded", deletedUsers);
        return result;
    }

    @ApiOperation("批量物理删除用户")
    @DeleteMapping("/dropBatch")
    public Result<Object> dropUsers(@RequestParam("ids") List<Integer> userIds) {
        log.info("userIds : {}", userIds.toString());
        log.info("Start dropping users");
        Result<Object> result = new Result<>();
        userService.deleteUserByIds(userIds);
        List<User> dbUsers = userService.getUserByIds(userIds);
        if (CollectionUtils.isEmpty(dbUsers)) {
            result.setResultSuccess("Batch drop user succeeded", null);
            log.info("Drop users end");
        } else {
            result.setResultFailed("");
            log.info("Drop users Failed");
        }
        return result;
    }

    @ApiOperation("物理删除用户")
    @DeleteMapping("/drop")
    public Result<Object> dropUser(@RequestParam("id") Integer userId) {
        log.info("userId : {}", userId);
        log.info("Start dropping user");
        Result<Object> result = new Result<>();
        userService.deleteUserById(userId);
        User dbUser = userService.getUserById(userId);
        if (dbUser == null) {
            result.setResultSuccess("drop user succeeded", null);
            log.info("Drop user end");
        } else {
            result.setResultFailed("drop user failed");
            log.info("Drop user failed");
        }
        return result;
    }

    @ApiOperation("获取所有用户")
    @GetMapping("/list")
    public Result<Object> listAllUser() {
        Result<Object> result = new Result<>();
        List<User> allUserList = userService.getAllUsers();
        if (CollectionUtils.isEmpty(allUserList)) {
            result.setResultFailed("Failed to get users");
            return result;
        }
        result.setResultSuccess("Get users successfully", allUserList);
        return result;
    }

    @ApiOperation("获取用户")
    @GetMapping("/listUser")
    public Result<Object> listUser(@RequestParam("id") Integer userId) {
        log.info("userId : {}", userId);
        Result<Object> result = new Result<>();
        User user = userService.getUserById(userId);
        if (user == null) {
            result.setResultFailed("Failed to get users");
            return result;
        }
        result.setResultSuccess("Get user successfully", user);
        return result;
    }

    @ApiOperation("批量获取用户")
    @GetMapping("/listUsers")
    public Result<Object> listUsers(@RequestParam("ids") List<Integer> userIds) {
        log.info("userIds : {}", userIds.toString());
        Result<Object> result = new Result<>();
        List<User> userList = userService.getUserByIds(userIds);
        if (userList.isEmpty()) {
            result.setResultFailed("Failed to get users");
            return result;
        }
        result.setResultSuccess("Get users successfully", userList);
        return result;
    }

    @ApiOperation("修改用户密码")
    @PutMapping("/updatePwd/{id}")
    public Result<Object> updateUserPwd(@PathVariable("id") Integer userId, @RequestParam String userPwd) {
        log.info("userId : {}, userPwd : {}", userId, userPwd);
        Result<Object> result = new Result<>();
        try {
            userService.updateUserPwdById(userId, userPwd);
        } catch (Exception e) {
            result.setResultFailed("Failed to update userPwd");
        }
        User dbUser = userService.getUserById(userId);
        if (dbUser == null) {
            result.setResultFailed("Failed to get user");
        }
        result.setResultSuccess("Update userPwd successfully", dbUser);
        return result;
    }

    @ApiOperation("修改用户基本信息")
    @PutMapping("/updateInfo/{id}")
    public Result<Object> updateUserInfo(@PathVariable("id") Integer userId,
                                         @RequestParam(required = false) String userName,
                                         @RequestParam(required = false) String userEmail,
                                         @RequestParam(required = false) Integer userAge,
                                         @RequestParam(required = false) String userGender) {
        log.info("userId : {}", userId);
        Result<Object> result = new Result<>();
        try {
            userService.updateUserInfoById(userId, userName, userEmail, userAge, userGender);
        } catch (Exception e) {
            result.setResultFailed("Failed to update userInfo");
        }
        User dbUser = userService.getUserById(userId);
        if (dbUser == null) {
            result.setResultFailed("Failed to get user");
        }
        result.setResultSuccess("Update userInfo successfully", dbUser);
        return result;
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

    public boolean validateUserIsExist(String userName) {
        User dbUser = userService.getUserByName(userName);
        return dbUser != null;
    }

    public boolean validateUserStatusIsD(Integer userId) {
        User dbUser = userService.getUserById(userId);
        return (StringUtils.equals(dbUser.getUserStatus(), "D"));
    }
}
