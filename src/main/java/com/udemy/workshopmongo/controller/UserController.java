package com.udemy.workshopmongo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.workshopmongo.model.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @GetMapping
    public ResponseEntity <List<User>> findAll() {
        return ResponseEntity.ok().body(null);
    }
}
