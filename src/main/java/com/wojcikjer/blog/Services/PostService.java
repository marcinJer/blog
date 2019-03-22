package com.wojcikjer.blog.Services;

import com.wojcikjer.blog.Entities.Post;
import com.wojcikjer.blog.Entities.User;
import com.wojcikjer.blog.Repositories.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class PostService {

    private PostRepository postRepository;

    public Post savePost(Post post){
        return postRepository.save(post);
    }
}
