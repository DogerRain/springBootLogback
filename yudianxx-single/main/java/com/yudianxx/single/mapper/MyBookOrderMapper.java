package com.yudianxx.single.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yudianxx.single.Object.Mybook;
import com.yudianxx.single.Object.MybookOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author huangyongwen
 * @date 2020/10/16
 * @Description
 */
@Component
public interface MyBookOrderMapper extends BaseMapper<MybookOrder> {

}
