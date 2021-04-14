package com.example.service.userService;

import com.example.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    List<User> findAllFromRepository();
    String postUsersFromRepository();

    User findUserByName(@PathVariable String name);

    List<User> findActiveUsers(Boolean isActive);

    User findUserById(Long id);

    void updateUserById(Long id);
}
