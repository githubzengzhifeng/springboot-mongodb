package com.unionman.springbootmongodbdemo.entity;

/**
 * @author Zhifeng.Zeng
 * @descrption
 * @date 2020/05/05 12:07
 */

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Zhifeng.Zeng
 * @description
 * @date 2020/1/14
 */
@Data
@Document(collection = "um_t_user")
public class User {

    @Id
    private ObjectId id;

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

    public String idToHex(){
        return id.toHexString();
    }
}
