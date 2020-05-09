package com.unionman.springbootmongodbdemo.service.impl;

import com.unionman.springbootmongodbdemo.entity.User;
import com.unionman.springbootmongodbdemo.pojo.dto.UserDTO;
import com.unionman.springbootmongodbdemo.pojo.vo.PageVO;
import com.unionman.springbootmongodbdemo.pojo.vo.UserVO;
import com.unionman.springbootmongodbdemo.repository.UserRepository;
import com.unionman.springbootmongodbdemo.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhifeng.Zeng
 * @descrption 用户管理业务实现类
 * @date 2020/05/05 12:11
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(UserDTO userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        user.setTimestamp(System.currentTimeMillis());
        userRepository.addUser(user);
    }

    @Override
    public void updateUser(UserDTO userDto) {
        User user = new User();
        user.setId(new ObjectId(userDto.getId()));
        BeanUtils.copyProperties(userDto,user);
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteUser(userId);
    }

    @Override
    public PageVO<UserVO> findUsers(UserDTO userDTO) {
        PageVO<UserVO> pageVO = new PageVO();
        Page<User> userPage = userRepository.findUsers(userDTO);
        List<User> userList = userPage.getContent();
        if(userList!=null && userList.size()>0){
            List<UserVO> userVoList = new ArrayList<>();
            userList.forEach(user->{
                UserVO userVo = new UserVO();
                BeanUtils.copyProperties(user,userVo);
                userVo.setId(user.getId().toHexString());
                userVoList.add(userVo);
            });
            pageVO.setRecords(userVoList);
        }
        pageVO.setTotalPages(userPage.getTotalPages());
        pageVO.setTotal(userPage.getTotalElements());
        pageVO.setIsLast(userPage.isLast());
        pageVO.setIsFirst(userPage.isFirst());
        pageVO.setHasPrevious(userPage.hasPrevious());
        pageVO.setCurrentPage(userDTO.getCurrentPage());
        pageVO.setPageSize(userDTO.getPageSize());
        return pageVO;
    }
}
