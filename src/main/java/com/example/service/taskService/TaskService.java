package com.example.service.taskService;

import com.example.model.TagColor;
import com.example.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllFromRepository();

    String postTasksFromRepository();

    Task findTaskById(Long id);

    Task findTaskByName(String name);

    void updateTaskById(Long id);

    List<Task> findTaskByUserId(Long id);

    List<Task> findTaskByTagId(Long id);

}
