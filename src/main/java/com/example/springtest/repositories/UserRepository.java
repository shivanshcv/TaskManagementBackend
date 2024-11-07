package com.example.springtest.repositories;

import com.example.springtest.entities.Task;
import com.example.springtest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmail(String email);
    User findByEmailAndPassword(String email, String password);

   // boolean exists();
}
