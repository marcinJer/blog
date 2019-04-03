package com.wojcikjer.blog.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity @Table @Data
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;

    private String content;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;
}
