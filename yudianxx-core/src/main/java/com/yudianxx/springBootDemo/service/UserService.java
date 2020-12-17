package com.yudianxx.springBootDemo.service;

import com.yudianxx.springBootDemo.annotation.MyAnnotation;
import com.yudianxx.springBootDemo.mapper.UserMapper;
import com.yudianxx.springBootDemo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("userService")
public class UserService {

    @Resource
    private UserMapper userDao;
    @Transactional
    @MyAnnotation(methodName = "userService.getUserById",description = "service层操作")
    public User getUserById(int userId) throws InterruptedException {
        Thread.sleep(1000);
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
//    //@Valid 默认校验整个对象的所有字段
//    public  Object addMessage(@Valid Message message, BindingResult result){
//        if (result.hasErrors()){  //校验满足了 例如@NotBlank
//            //
//            result.getAllErrors().get(0).getDefaultMessage(); //返回第一个不满足的提示错误
////            throw  new RuntimeException("111");
//            throw  new RuntimeException(result.getAllErrors().get(0).getDefaultMessage());
//        }
//        return null;
//    }
}
