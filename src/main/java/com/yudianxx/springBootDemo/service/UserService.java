package com.yudianxx.springBootDemo.service;

import com.yudianxx.springBootDemo.mapper.UserMapper;
import com.yudianxx.springBootDemo.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserService {

    @Resource
    private UserMapper userDao;
    @Transactional
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
