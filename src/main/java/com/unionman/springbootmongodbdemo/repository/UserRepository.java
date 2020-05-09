package com.unionman.springbootmongodbdemo.repository;

import com.unionman.springbootmongodbdemo.entity.User;
import com.unionman.springbootmongodbdemo.pojo.dto.UserDTO;
import org.springframework.data.domain.Page;

/**
 * @author Zhifeng.Zeng
 * @descrption 用户管理持久化接口
 * @date 2020/05/05 12:25
 */
public interface UserRepository {

    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 编辑用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(String userId);

    /**
     * 查询用户
     */
    Page<User> findUsers(UserDTO userDTO);
}
