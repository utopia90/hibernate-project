package com.example.dao.userDAO;

import com.example.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserDAO {

    List<User> findAllFromRepository();
    String postUsersFromRepository();
    User findUserByName(@PathVariable String name);
    List<User> findActiveUsers(Boolean isActive);
    User findUserById(@PathVariable Long id);
    void updateUserById(@PathVariable Long id);
}
