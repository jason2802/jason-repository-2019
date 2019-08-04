package com.perso.customvalidation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perso.customvalidation.domain.User;
import com.perso.customvalidation.service.UserService;

@RestController
public class UserController {
 
	@Autowired
	UserService userService;
	
    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        // persisting the user
        return ResponseEntity.ok("User is valid");
    }
    
    @RequestMapping("")
    ResponseEntity<String> getUser() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok("User is valid");
    }
     
    // standard constructors / other methods
     
}