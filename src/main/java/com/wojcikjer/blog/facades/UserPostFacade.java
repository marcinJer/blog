package com.wojcikjer.blog.facades;

import com.wojcikjer.blog.Entities.Post;
import com.wojcikjer.blog.Services.PostService;
import com.wojcikjer.blog.Services.UserService;
import com.wojcikjer.blog.exceptions.BadRequestException;
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
        return postService.editPostById(post,id);
    }

    public void deleteCurrentUsersPost(String username, Long id){
        Post post = postService.findPostById(id);
        if (post.getUser().getUsername().equals(username)){
            postService.deletePostById(id);
        }else throw new BadRequestException("You're trying to delete not your post!");
    }

}
