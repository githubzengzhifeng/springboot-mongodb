package com.unionman.springbootmongodbdemo.pojo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Zhifeng.Zeng
 * @descrption
 * @date 2020/05/05 12:12
 */
@Setter
@Getter
public class UserDTO extends PageDTO{

    private String id;

    /**
     * 时间戳
     */
    @Indexed
    private Long timestamp;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 住址
     */
    private String address;
}
