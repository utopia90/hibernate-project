package com.example.dao.userDAO;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.ElementCollection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAllFromRepository() {
        return repository.findAllEager();
    }

    @Override
    @ElementCollection
    public String postUsersFromRepository() {

        User user1 = new User("Sofía","López","838398393D",true,"09/02/1987");
        User user2 = new User("Marcos","Fernández","19294843D",true,"03/02/1980");
        User user3 = new User("Mónica","García","62521843D",false,"03/02/1990");
        User user4 = new User("José","Robles","19292843D",false,"06/08/1995");
        User user5 = new User("Lorena","Campos","21282843D",false,"08/01/1992");


      if(repository.findUserByName(user1.getName()) == null){
          manager.persist(user1);
      }else{
          return "user already exists";
      }
        if(repository.findUserByName(user2.getName()) == null){
            manager.persist(user2);
        }else{
            return "user already exists";
        }
        if(repository.findUserByName(user3.getName()) == null){
            manager.persist(user3);
        }else{
            return "user already exists";
        }
        if(repository.findUserByName(user4.getName()) == null){
            manager.persist(user4);
        }else{
            return "user already exists";
        }
        if(repository.findUserByName(user5.getName()) == null){
            manager.persist(user5);
        }else{
            return "user already exists";
        }

        return "users inserted succesfuly";
    }

    @Override
    public User findUserByName(@PathVariable String name) {
        return repository.findUserByName(name);
    }

    @Override
    public List<User> findActiveUsers(Boolean isActive) {
        return repository.findAllActiveUsers(isActive);
    }

    @Override
    public User findUserById(@PathVariable Long id) {
        return repository.findUserById(id);
    }

    @Override
    public void updateUserById(@PathVariable Long id) {
         repository.updateUserById(id);
    }
}
