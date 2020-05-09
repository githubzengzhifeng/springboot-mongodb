package com.unionman.springbootmongodbdemo.repository.impl;

import com.unionman.springbootmongodbdemo.entity.User;
import com.unionman.springbootmongodbdemo.pojo.dto.UserDTO;
import com.unionman.springbootmongodbdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Zhifeng.Zeng
 * @descrption 用户管理持久化实现类
 * @date 2020/05/05 12:25
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addUser(User user) {
        mongoTemplate.insert(user);
    }

    @Override
    public void updateUser(User user) {
        Query updateQuery = new Query();
        updateQuery.addCriteria(Criteria.where("_id").is(user.getId().toHexString()));
        Update update = new Update();
        update.set("address",user.getAddress());
        update.set("age",user.getAge());
        update.set("name",user.getName());
        update.set("sex",user.getSex());
        mongoTemplate.updateMulti(updateQuery,update,User.class);
    }

    @Override
    public void deleteUser(String userId) {
        Query deleteQuery = new Query();
        deleteQuery.addCriteria(Criteria.where("_id").is(userId));
        mongoTemplate.remove(deleteQuery,User.class);
    }

    @Override
    public Page<User> findUsers(UserDTO userDTO) {
        Query query = new Query();

        if(userDTO.getAddress() != null){
            Pattern pattern = Pattern.compile("^.*" + userDTO.getAddress() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("address").regex(pattern));
        }

        if(userDTO.getAge() != null){
            query.addCriteria(Criteria.where("age").is(userDTO.getAge()));

        }

        if(userDTO.getSex() != null){
            query.addCriteria(Criteria.where("sex").is(userDTO.getSex()));

        }


        if(userDTO.getName() != null){
            query.addCriteria(Criteria.where("name").is(userDTO.getName()));

        }

        // 排序方式
        Sort sort = new Sort(Sort.Direction.DESC, "timestamp");

        // 分页条件
        Pageable pageable = PageRequest.of(userDTO.getCurrentPage(), userDTO.getPageSize(), sort);
        List<User> userList = mongoTemplate.find(query.with(pageable), User.class);
        long count = mongoTemplate.count(query, User.class);
        return new PageImpl<>(userList,pageable,count);
    }
}
