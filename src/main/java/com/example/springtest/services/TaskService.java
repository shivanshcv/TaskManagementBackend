package com.example.springtest.services;

import com.example.springtest.entities.Task;
import com.example.springtest.pojos.TaskDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface TaskService {
    List<Task> tasks = new ArrayList<>();

   // List<Task> getAllUserTasks(String userId);

    List<Task> getAllUserTasks(Long userId);

    public Task getTask(Long id);

    public Task addTask(TaskDto taskDto);

    public Task updateTask(Long id, TaskDto taskDto);

    public void deleteTask(Long id);

    public Task pendingToInProgress(Long id, TaskDto taskDto);

    public Task InProgressBackToPending(Long id, TaskDto taskDto);

    public Task InProgressToDone(Long id, TaskDto taskDto);

}
