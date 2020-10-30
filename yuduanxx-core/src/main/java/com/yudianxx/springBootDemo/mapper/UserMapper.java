package com.yudianxx.springBootDemo.mapper;

import com.yudianxx.springBootDemo.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Integer id);

}
