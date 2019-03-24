package com.wojcikjer.blog.facades;

import com.wojcikjer.blog.Entities.Post;
import com.wojcikjer.blog.Services.PostService;
import com.wojcikjer.blog.Services.UserService;
import com.wojcikjer.blog.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Transactional

public class UserPostFacade {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    public Post savePostToCurrentUser(String username, Post post){
        post.setUser(userService.findUserByUsername(username).orElseThrow(() -> new NotFoundException("User not found")));
        return postService.savePost(post);
    }

    public Post editCurrentUsersPost(String username, Post post, Long id){
        post.setUser(userService.findUserByUsername(username).orElseThrow(() -> new NotFoundException("User not found")));
        post.setId(id);
        return postService.editPost(post,id);
    }

}
