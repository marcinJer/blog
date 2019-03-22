package com.wojcikjer.blog.facades;

import com.wojcikjer.blog.Entities.Post;
import com.wojcikjer.blog.Entities.User;
import com.wojcikjer.blog.Services.PostService;
import com.wojcikjer.blog.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

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

}
