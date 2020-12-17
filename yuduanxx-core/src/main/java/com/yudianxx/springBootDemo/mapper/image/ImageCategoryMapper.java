package com.yudianxx.springBootDemo.mapper.image;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yudianxx.springBootDemo.model.image.Category;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

@Resource
@Mapper
public interface ImageCategoryMapper extends BaseMapper<Category> {


}
