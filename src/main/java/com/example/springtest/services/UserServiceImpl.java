package com.example.springtest.services;

import com.example.springtest.entities.User;
import com.example.springtest.exceptions.UserNotFoundException;
import com.example.springtest.pojos.UserDto;
import com.example.springtest.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;




    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;


    }

    @Override
    public User userSignUp(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return userRepository.save(user);


    }

    @Override
    public UserDto userLogin(String email, String password) {

        User user = userRepository.findByEmailAndPassword(email, password);
        if(user != null) {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            return userDto;
        }
            throw new RuntimeException("User does not exist");

    }
}
