package com.example.service.taskService;

import com.example.dao.BillingInfoDAO.BillingInfoDAO;
import com.example.dao.taskDAO.TaskDAO;
import com.example.model.TagColor;
import com.example.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskDAO taskDao;
    public TaskServiceImpl(TaskDAO taskDAO) {
        this.taskDao = taskDAO;
    }


    @Override
    public List<Task> findAllFromRepository() {
        return this.taskDao.findAllFromRepository();
    }

    @Override
    public String postTasksFromRepository() {
        return this.taskDao.postTasksFromRepository();
    }

    @Override
    public Task findTaskById(@PathVariable Long id) {
        return this.taskDao.findTaskById(id);
    }

    @Override
    public Task findTaskByName(@PathVariable String name) {
        return this.taskDao.findTaskByName(name);
    }

    @Override
    public void updateTaskById(@PathVariable Long id) {
        this.taskDao.updateTaskById(id);
    }

    @Override
    public List<Task> findTaskByUserId(@PathVariable Long id) {
        return this.taskDao.findTasksByUserId(id);
    }

    @Override
    public List<Task> findTaskByTagId(@PathVariable Long id) {
        return taskDao.findTasksByTagId(id);
    }


}
