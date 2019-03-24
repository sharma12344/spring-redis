package com.stackroute.cache.springredisexample;


import com.stackroute.cache.springredisexample.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/user")
@CrossOrigin("*")
public class UserResource {

    private UserRepository userRepository;

    public UserResource(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
    }

    // Get mapping to add a particular value by id
    @PostMapping("/add/{id}/{name}")
    public User add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        userRepository.save(new User(id, name, 2000L));
        return userRepository.findById(id);
    }

    // Put mapping to update a particular value by id
    @PutMapping("/update/{id}/{name}")
    public User update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        userRepository.update(new User(id, name, 2000L));
        return userRepository.findById(id);
    }

    //// Delete mapping to delete a particular value by id
    @DeleteMapping("/delete/{id}")
    public Map<String, User> delete(@PathVariable("id") final String id) {
        userRepository.delete(id);
        return all();
    }

    // Get mapping to show all key values for that particular hash
    @GetMapping("/all")
    public Map<String, User> all() {
        return userRepository.findAll();
    }
}
