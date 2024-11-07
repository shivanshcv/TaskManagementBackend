package com.example.springtest.services;

import com.example.springtest.entities.User;
import com.example.springtest.pojos.UserDto;
import org.springframework.stereotype.Service;


public interface UserService {
    User userSignUp(UserDto userDto);
    UserDto userLogin(String email, String password);
}
