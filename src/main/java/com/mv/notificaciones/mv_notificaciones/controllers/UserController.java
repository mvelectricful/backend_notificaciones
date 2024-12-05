package com.mv.notificaciones.mv_notificaciones.controllers;

import com.mv.notificaciones.mv_notificaciones.entities.User;
import com.mv.notificaciones.mv_notificaciones.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public List<User> list(){
        return service.findAll();
    }
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        user.setAdmin(false);
        return create(user);
    }





}
