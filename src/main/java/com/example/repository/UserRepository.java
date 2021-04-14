package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "tasks")
    @Query("SELECT e FROM User e")
    List<User> findAllEager();

    @EntityGraph(attributePaths = {"name"})
    @Query("SELECT e FROM User e where e.name = :name")
    User findUserByName(@Param("name")  String name);

    @EntityGraph(attributePaths = {"isActive"})
    @Query("SELECT e FROM User e where e.isActive = true")
    List<User> findAllActiveUsers(Boolean isActive);

    @EntityGraph(attributePaths = {"id"})
    @Query("SELECT e FROM User e where e.id = :id")
    User findUserById(@Param("id")  Long id);

    @EntityGraph(attributePaths = {"id"})
    @Modifying
    @Query("UPDATE User set name='nameUpdated', surname='surnameUpdated', dni='dniUpdated' where id = :id")
    void updateUserById(@Param("id")  Long id);
}
