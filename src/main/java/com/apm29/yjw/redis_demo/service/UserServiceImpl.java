package com.apm29.yjw.redis_demo.service;

import com.apm29.yjw.redis_demo.domain.BaseResp;
import com.apm29.yjw.redis_demo.domain.User;
import com.apm29.yjw.redis_demo.persistence.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements  UserService {

    private UserJpaRepository userJpaRepository;

    @Autowired
    public UserServiceImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public List<User> all() {
        return userJpaRepository.findAll();
    }

    @Override
    public User byName(String userName) {
        return userJpaRepository.findByUserName(userName);
    }


    @Override
    public BaseResp<User> save(String userName) {


        User entity = new User();
        entity.setUserName(userName);
        try {
            return BaseResp.ok(userJpaRepository.save(entity));
        } catch (Throwable e) {
            e.printStackTrace();
            return BaseResp.err("用户已存在",entity);
        }

    }
}
