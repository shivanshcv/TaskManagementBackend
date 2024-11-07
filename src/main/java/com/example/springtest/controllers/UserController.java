package com.example.springtest.controllers;

import com.example.springtest.entities.User;
import com.example.springtest.pojos.UserDto;
import com.example.springtest.pojos.UserResponseDto;
import com.example.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final UserResponseDto userResponseDto;

    public UserController(UserService userService, UserResponseDto userResponseDto) {
        this.userService = userService;
        this.userResponseDto = userResponseDto;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> userSignUp(@RequestBody UserDto userDto) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        userService.userSignUp(userDto);
        map.put("status", 1);
        map.put("message", "Signed up successfully!");
        map.put("user", userDto);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody UserDto userDto) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
       userService.userLogin(userDto.getEmail(), userDto.getPassword());
        map.put("status", 1);
        map.put("message", "Login successful!");
        map.put("user", userDto);
        //UserDto oauthUser = userService.userLogin(userDto.getEmail(), userDto.getPassword());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
