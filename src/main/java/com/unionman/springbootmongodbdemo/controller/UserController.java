package com.unionman.springbootmongodbdemo.controller;

import com.unionman.springbootmongodbdemo.pojo.dto.UserDTO;
import com.unionman.springbootmongodbdemo.pojo.vo.PageVO;
import com.unionman.springbootmongodbdemo.pojo.vo.ResponseVO;
import com.unionman.springbootmongodbdemo.pojo.vo.UserVO;
import com.unionman.springbootmongodbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Zhifeng.Zeng
 * @descrption
 * @date 2020/05/05 11:20
 */

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * 添加用户
     * @param userDto
     */
    @PostMapping
    public ResponseVO addUser(@RequestBody UserDTO userDto){
        userService.addUser(userDto);
        return ResponseVO.success();
    }

    /**
     * 编辑用户
     * @param userDto
     */
    @PutMapping
    public ResponseVO updateUser(@RequestBody UserDTO userDto){
        userService.updateUser(userDto);
        return ResponseVO.success();
    }

    /**
     * 删除用户
     * @param userId
     */
    @DeleteMapping("/{userId}")
    public ResponseVO deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
        return ResponseVO.success();
    }

    /**
     * 查询用户
     */
    @GetMapping
    public ResponseVO<PageVO<UserVO>> findUsers(UserDTO userDTO){
        PageVO<UserVO> userVoPageVo = userService.findUsers(userDTO);
        return ResponseVO.success(userVoPageVo);
    }

}
