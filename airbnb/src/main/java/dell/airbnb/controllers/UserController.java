package main.java.dell.airbnb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dell.airbnb.entities.User;
import dell.airbnb.repositories.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository repo;

    @Autowired
    CreateUserService createUserService;

    @GetMapping(value = "/user")
    public List<User> index() {
        return repo.getAll();
    }

    @GetMapping(value = "/user/{id}")
    public User show(@PathVariable("id") int id){
        User user = repo.getOne(id);
        return user;
    }

    @PostMapping(value = "/user")
    public User create(@RequestBody User user){
        return createUserService.run(user);
    }

    @PostMapping(value = "/user/{id}")
    public void update(
        @PathVariable("id") int id, 
        @RequestBody User newUser){
        repo.updateUser(id,newUser);
    }

    @DeleteMapping(value = "/user/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteUser(id);
    }
}