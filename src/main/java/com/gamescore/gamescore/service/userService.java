package com.gamescore.gamescore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamescore.gamescore.model.User;
import com.gamescore.gamescore.repository.userRepository;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }
}
