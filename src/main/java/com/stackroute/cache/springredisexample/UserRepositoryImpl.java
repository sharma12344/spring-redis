package com.stackroute.cache.springredisexample;

import com.stackroute.cache.springredisexample.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private RedisTemplate<String, User> redisTemplate;

    private HashOperations hashOperations;


    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    //this method will save value corresponding to a key
    @Override
    public void save(User user) {

        hashOperations.put("USER", user.getId(), user);
    }

    // this method will return values corresponding to that hash
    @Override
    public Map<String, User> findAll() {
        return hashOperations.entries("USER");
    }

    // this method will return a user corresponding to that id in that particular hash
    @Override
    public User findById(String id) {
        return (User) hashOperations.get("USER", id);
    }

    // this method will update a user corresponding to that id in that particular hash
    @Override
    public void update(User user) {

        save(user);
    }

    // this method will delete a user corresponding to that id in that particular hash
    @Override
    public void delete(String id) {

        hashOperations.delete("USER", id);
    }
}
