package com.unionman.springbootmongodbdemo.service;

import com.unionman.springbootmongodbdemo.pojo.dto.UserDTO;
import com.unionman.springbootmongodbdemo.pojo.vo.PageVO;
import com.unionman.springbootmongodbdemo.pojo.vo.UserVO;

/**
 * @author Zhifeng.Zeng
 * @descrption 用户管理业务接口
 * @date 2020/05/05 12:10
 */
public interface UserService {

    /**
     * 添加用户
     * @param userDto
     */
    void addUser(UserDTO userDto);

    /**
     * 编辑用户
     * @param userDto
     */
    void updateUser(UserDTO userDto);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(String userId);

    /**
     * 查询用户
     */
    PageVO<UserVO> findUsers(UserDTO userDTO);
}
