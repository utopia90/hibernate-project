package com.example.controller;

import com.example.model.*;
import com.example.service.taskService.TaskService;
import com.example.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> findAll() {

        return taskService.findAllFromRepository();
    }
    @GetMapping("/tasks/id/{id}")
    public ResponseEntity<Task> findTaskById(@PathVariable Long id) {

        Task taskOpt = taskService.findTaskById(id);
        if( taskOpt != null){
            return ResponseEntity.ok().body(taskOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/tasks/name/{name}")
    public ResponseEntity<Task> findTaskByName(@PathVariable String name) {

        Task taskOpt = taskService.findTaskByName(name);
        if( taskOpt != null){
            return ResponseEntity.ok().body(taskOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/tasks-user/id/{id}")
    public ResponseEntity<List<Task>> findTasksByUserId(@PathVariable Long id) {

        List<Task> taskOpt = taskService.findTaskByUserId(id);
        if( taskOpt != null){
            return ResponseEntity.ok().body(taskOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/tasks-tags/id/{id}")
    public ResponseEntity<List<Task>> findTasksByTagId(@PathVariable Long id) {

        List<Task> taskOpt = taskService.findTaskByTagId(id);
        if( taskOpt != null){
            return ResponseEntity.ok().body(taskOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tasks/post")
    public String  postTasks(){
        return  taskService.postTasksFromRepository();
    }

    @PutMapping("/tasks/update/{id}")
    public  ResponseEntity<Task> updateTaskById(@PathVariable("id") Long id) { log.debug("REST request to update a id{}", id);

        if(taskService.findTaskById(id) == null){
            log.warn("updating task without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            taskService.updateTaskById(id);
            return ResponseEntity.ok().body(taskService.findTaskById(id));
        }
    }
}
