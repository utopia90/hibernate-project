package com.example.dao.taskDAO;

import com.example.model.TagColor;
import com.example.model.Task;

import java.util.List;

public interface TaskDAO {
    List<Task> findAllFromRepository();

    String postTasksFromRepository();

    Task findTaskById(Long id);

    Task findTaskByName(String name);

    void updateTaskById(Long id);

    List<Task> findTasksByUserId(Long Id);

    List<Task> findTasksByTagId(Long id);

}
