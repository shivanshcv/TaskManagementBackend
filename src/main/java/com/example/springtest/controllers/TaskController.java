package com.example.springtest.controllers;

import com.example.springtest.entities.Task;
import com.example.springtest.pojos.TaskDto;
import com.example.springtest.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    TaskDto taskDto;


    //To fetch a task
    @GetMapping("/task/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
      Task task = taskService.getTask(taskId);
       // TaskDto task = null;
        return new ResponseEntity<>(task, HttpStatus.OK);
    }


    //To add/ create a new task
    @PostMapping("/addtask")
    public ResponseEntity<TaskDto> addTask(@RequestBody TaskDto taskDto){
        taskService.addTask(taskDto);
        //String outcome = "Task is added successfully!";
    return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }


    //To update a task
    @PutMapping("/update/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.updateTask(taskId, taskDto);
        return new ResponseEntity<>("Task updated successfully!", HttpStatus.OK);
    }

    //To delete a task by Id
    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>("Task deleted successfully!", HttpStatus.NO_CONTENT);
    }

    //To change the status of a task from pending to in-progress using the task id
    @PutMapping("/status/prog/{taskId}")
    public ResponseEntity<String> pendingToProgress(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.pendingToInProgress(taskId, taskDto);
        return new ResponseEntity<>("Task status changed successfully!", HttpStatus.OK);
    }


    //To change the status of a task from in-progress back to pending using the task id
    @PutMapping("/status/pend/{taskId}")
    public ResponseEntity<String> InProgressToPending(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.InProgressBackToPending(taskId, taskDto);
        return new ResponseEntity<>("Task status changed successfully", HttpStatus.OK);
    }


    //To change the status of a task from in-progress to done using the task id
    @PutMapping("/status/done/{taskId}")
    public ResponseEntity<String> InProgressToDone(@PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        taskService.InProgressToDone(taskId, taskDto);
        return new ResponseEntity<>("Task status changed successfully", HttpStatus.OK);
    }

}
