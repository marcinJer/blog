package com.wojcikjer.blog.Controllers;

import com.wojcikjer.blog.Entities.Post;
import com.wojcikjer.blog.Entities.User;
import com.wojcikjer.blog.Services.PostService;
import com.wojcikjer.blog.Services.UserService;
import com.wojcikjer.blog.facades.UserPostFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserPostFacade userPostFacade;
    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity getUsers() {

        return new ResponseEntity(userService.findAllUsers(),
                HttpStatus.OK);
    }

    @PostMapping("/registration")
    public ResponseEntity register(@RequestBody User user) {
        if (user.getId() == null) {
            try {
                userService.saveUser(user);
                return new ResponseEntity(HttpStatus.OK);
            } catch (DataIntegrityViolationException e) {
                //empty intentionally
            }
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("User already exists");
    }

    @PostMapping("/{username}/posts")
    public Post savePost(@PathVariable String username, @RequestBody Post post){

        return userPostFacade.savePostToCurrentUser(username, post);
    }

    @PutMapping("/{username}/posts/{postId}")
    public Post editPostById(@PathVariable String username, @PathVariable Long postId, @RequestBody Post post){
        return userPostFacade.editCurrentUsersPost(username, post, postId);
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


