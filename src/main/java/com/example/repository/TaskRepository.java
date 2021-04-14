package com.example.repository;

import com.example.model.TagColor;
import com.example.model.Task;
import com.example.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @EntityGraph(attributePaths = "user")
    @Query("SELECT e FROM Task e")
    List<Task> findAllEager();

    @EntityGraph(attributePaths = {"id"})
    @Query("SELECT e FROM Task e where e.id = :id")
    Task findTaskById(@Param("id") Long id);

    @EntityGraph(attributePaths = {"title"})
    @Query("SELECT e FROM Task e where e.title = :name")
    Task findTaskByName(@Param("name") String name);

    @EntityGraph(attributePaths = {"id"})
    @Modifying
    @Query("UPDATE Task set title='titleUpdated', description='descriptionUpdated' where id = :id")
    void updateTaskById(@Param("id") Long id);


    @EntityGraph(attributePaths = {"id"})
    @Query("SELECT e from Task e where e.user.id like :id")
    List<Task> findTasksByUserId(@Param("id") Long id);

    @EntityGraph(attributePaths = {"id"})
    @Query("from Task e left outer join fetch e.tag t where t.id=:id")
    List<Task> findTaskByTagId(Long id);
}
