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
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUsers() {

        return new ResponseEntity(userService.findAllUsers(),
                HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity getUser(@PathVariable String username) {
        return new ResponseEntity(userService.findUserByUsername(username),
                HttpStatus.OK);
    }

    @GetMapping("/{username}/posts")
    public ResponseEntity getUserPosts(@PathVariable String username) {

        return new ResponseEntity(userService.findUserByUsername(username).get().getPosts(),
                HttpStatus.OK);
    }

    // add GET mapping: /{id}/{post}
    @GetMapping("/{username}/posts/{postId}")
    public ResponseEntity getUserPost(@PathVariable String username,
                                      @PathVariable long postId) {

        return new ResponseEntity(userService.findUserByUsername(username).get().getPosts().get((int) postId - 1),
                HttpStatus.OK);
    }

}


