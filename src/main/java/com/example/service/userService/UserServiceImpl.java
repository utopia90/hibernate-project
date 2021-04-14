package com.example.service.userService;

import com.example.dao.userDAO.UserDAO;
import com.example.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;


    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public List<User> findAllFromRepository() {
        List<User> users = this.userDAO.findAllFromRepository();
        return users;
    }

    @Override
    public String postUsersFromRepository() {
      return this.userDAO.postUsersFromRepository();
    }

    @Override
    public User findUserByName(@PathVariable String name) {
        User user =  this.userDAO.findUserByName(name);
        return user;
    }

    @Override
    public List<User> findActiveUsers(Boolean isActive) {
        List<User> users = this.userDAO.findActiveUsers(isActive);
        return users;

    }

    @Override
    public User findUserById(@PathVariable Long id) {
        User user =  this.userDAO.findUserById(id);
        return user;
    }

    @Override
    public void updateUserById(@PathVariable Long id) {
      this.userDAO.updateUserById(id);
    }
}
