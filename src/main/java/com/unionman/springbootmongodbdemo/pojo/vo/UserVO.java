package com.unionman.springbootmongodbdemo.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Zhifeng.Zeng
 * @descrption
 * @date 2020/05/05 12:13
 */
@Setter
@Getter
public class UserVO {

    private String id;

    /**
     * 时间戳
     */
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
