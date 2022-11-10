package com.webmattic.jpa.service;

import com.webmattic.jpa.dao.UserRepository;
import com.webmattic.jpa.exception.UserServiceException;
import com.webmattic.jpa.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<Users> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Users getUser(Integer userId){
        return userRepository.findById(userId).orElseThrow(()->{
            return new UserServiceException("User not Found Exception");
        });
    }

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
