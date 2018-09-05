package com.apm29.yjw.redis_demo.service;

import com.apm29.yjw.redis_demo.domain.BaseResp;
import com.apm29.yjw.redis_demo.domain.User;

import java.util.List;
public interface UserService {
    List<User> all();
    User byName(String userName);

    BaseResp<User> save(String userName);
}
