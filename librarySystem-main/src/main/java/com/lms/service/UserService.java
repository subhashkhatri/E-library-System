package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.entity.User;
import com.lms.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User findById(Long id)
    {
    	return userRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
