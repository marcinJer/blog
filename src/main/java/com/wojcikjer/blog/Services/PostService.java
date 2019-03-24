package com.wojcikjer.blog.Services;

import com.wojcikjer.blog.Entities.Post;
import com.wojcikjer.blog.Repositories.PostRepository;
import com.wojcikjer.blog.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public Post editPost(Post updatedPost, Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new NotFoundException("Post [id = " + id + "] not found"));
        Optional.ofNullable(updatedPost.getContent()).ifPresent(post::setContent);
        Optional.ofNullable(updatedPost.getUser()).ifPresent(post::setUser);
        Optional.ofNullable(updatedPost.getComments()).ifPresent(post::setComments);

        return postRepository.save(post);
    }
}
