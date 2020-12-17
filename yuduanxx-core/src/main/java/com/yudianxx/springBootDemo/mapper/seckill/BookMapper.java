package com.yudianxx.springBootDemo.mapper.seckill;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yudianxx.springBootDemo.model.seckill.Book;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

/**
 * @author huangyongwen
 * @date 2020/10/16
 * @Description
 */
@Resource
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
