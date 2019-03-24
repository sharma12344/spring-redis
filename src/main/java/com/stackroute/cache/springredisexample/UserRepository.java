package com.stackroute.cache.springredisexample;

import com.stackroute.cache.springredisexample.model.User;

import java.util.Map;

public interface UserRepository {
    //various CRUD Operation method calls
    void save(User user);

    Map<String, User> findAll();

    User findById(String id);

    void update(User user);

    void delete(String id);
}
