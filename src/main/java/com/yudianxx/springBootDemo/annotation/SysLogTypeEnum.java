package com.yudianxx.springBootDemo.annotation;

import lombok.Getter;

public enum SysLogTypeEnum {
    /**
     * 未定义
     * @see SysLog#type() 默认值
     */
    UNDEFINED("未定义"),

    /**
     * 查询
     */
    QUERY("查询"),

    /**
     * 新增
     */
    INSERT("新增"),

    /**
     * 更新
     */
    UPDATE("更新"),

    /**
     * 删除
     */
    DELETE("删除");

    @Getter
    private String name;

    SysLogTypeEnum(String name){
        this.name = name;
    }

}
