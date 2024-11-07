package com.example.springtest.repositories;


import com.example.springtest.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByUserId(Long id);

    Task findTaskById(Long id);

    void deleteById(String taskId);

//    Optional<Task> findByTaskName(String taskName);
//
//    Task findById(String id);
//
//    List<Task> findByCreatedAt(Date createdAt);

    //Optional<Sample> findOne(String taskName);
}
