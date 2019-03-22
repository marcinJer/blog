package com.wojcikjer.blog.Services;

import com.wojcikjer.blog.Entities.User;
import com.wojcikjer.blog.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(long id) {

        return userRepository.findById(id);
    }

    public Optional<User> findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

}
