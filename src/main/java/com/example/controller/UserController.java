package com.example.controller;

import com.example.model.User;
import com.example.service.userService.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {

        return userService.findAllFromRepository();
    }
    @PostMapping("/users/post")
    public String  postUsers(){
       return  userService.postUsersFromRepository();
    }

    @GetMapping("/users/name/{name}")
    public ResponseEntity<User> findUserByName(@PathVariable String name) {

        User userOpt = userService.findUserByName(name);
        if( userOpt != null){
            return ResponseEntity.ok().body(userOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/users/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {

        User userOpt = userService.findUserById(id);
        if( userOpt != null){
            return ResponseEntity.ok().body(userOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/users/isActive/{isActive}")
    public  ResponseEntity<List<User>> findActiveUsers(@PathVariable Boolean isActive) {

        List<User> userOpt = userService.findActiveUsers(isActive);

        if( userOpt != null){
            return ResponseEntity.ok().body(userOpt);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
      @PutMapping("/users/update/{id}")
      public  ResponseEntity<User> updateUserById(@PathVariable("id") Long id) { log.debug("REST request to update a id{}", id);

      if( userService.findUserById(id) == null){
          log.warn("updating user without id");
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }else{
          userService.updateUserById(id);
         return ResponseEntity.ok().body(userService.findUserById(id));
       }
   }
}
