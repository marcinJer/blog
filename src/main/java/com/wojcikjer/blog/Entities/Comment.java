package com.wojcikjer.blog.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity @Table
@Data
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Post post;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;
}
