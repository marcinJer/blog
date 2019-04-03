package com.wojcikjer.blog.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table @Data
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;

    private String content;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

}
