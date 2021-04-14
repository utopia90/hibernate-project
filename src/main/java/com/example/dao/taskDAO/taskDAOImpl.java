package com.example.dao.taskDAO;


import com.example.model.TagColor;
import com.example.model.Task;
import com.example.model.User;
import com.example.repository.TaskRepository;
import com.example.repository.UserRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class taskDAOImpl implements TaskDAO{

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAllFromRepository() {
        return taskRepository.findAllEager();
    }

    @Override
    public String postTasksFromRepository() {
        Task task1 = new Task("study java", "study java by doing project hibernate", false, LocalDate.of(2021,04,9));
        Task task2 = new Task("work in project angular", "angular project 1 implementation", false, LocalDate.of(2021,05,2));
        Task task3 = new Task("work in project angular advanced", "angular project 1 implementation", false, LocalDate.of(2021,05,2));
        Task task4 = new Task("spring rest api", "Spring rest api implementation", true, LocalDate.of(2021,03,27));
        Task task5 = new Task("testing with mockito", "Mockito test project implementation", true, LocalDate.of(2021,03,20));

        User user1 = new User("Ariadna", "López", "83838383P", true,"09/02/1989");
        User user2= new User("Salvador", "Castilla", "27398340S", true,"09/02/1991");


        if(taskRepository.findTaskByName(task1.getTitle()) == null){
            task1.setUser(user1);
            manager.persist(task1);
            manager.persist(user1);
        }else{
            return "task already exists";
        }
        if(taskRepository.findTaskByName(task2.getTitle()) == null){
            task2.setUser(user1);
            manager.persist(task2);
            manager.persist(user1);

        }else{
            return "task already exists";
        }
        if(taskRepository.findTaskByName(task3.getTitle()) == null){
            task3.setUser(user1);
            manager.persist(task3);
            manager.persist(user1);


        }else{
            return "task already exists";
        }
        if(taskRepository.findTaskByName(task4.getTitle()) == null){
            task4.setUser(user2);
            manager.persist(task4);
            manager.persist(user2);


        }else{
            return "task already exists";
        }
        if(taskRepository.findTaskByName(task5.getTitle()) == null){
            task5.setUser(user2);
            manager.persist(task5);
            manager.persist(user2);


        }else{
            return "task already exists";
        }
        return "tasks inserted succesfuly";
    }

    @Override
    public Task findTaskById(@PathVariable Long id) {
        return taskRepository.findTaskById(id);
    }

    @Override
    public Task findTaskByName(@PathVariable String name) {
        return taskRepository.findTaskByName(name);
    }

    @Override
    public void updateTaskById(@PathVariable Long id) {
        taskRepository.updateTaskById(id);
    }

    @Override
    public List<Task> findTasksByUserId(@PathVariable Long id) {
       return taskRepository.findTasksByUserId(id);

    }

    @Override
    public List<Task> findTasksByTagId(@PathVariable Long id) {
        return taskRepository.findTaskByTagId(id);
    }}


