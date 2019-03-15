package com.wojcikjer.blog.Controllers;

import com.wojcikjer.blog.Entities.User;
import com.wojcikjer.blog.Entities.UserContext;
import com.wojcikjer.blog.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserContext userContext;

    private User currentUser;

    @GetMapping("/home")
    public ResponseEntity home() {

        long id = userContext.getCurrentUser().getId();

        return new ResponseEntity(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getUsers() {
        return new ResponseEntity(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable long id) {
        return new ResponseEntity(userService.findUserById(id), HttpStatus.OK);
    }

}
