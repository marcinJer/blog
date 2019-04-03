package com.wojcikjer.blog.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Table @Data
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;

    private String username;

    private String password;

    @ManyToMany
    @JoinTable(
            name = "followers",
            joinColumns = {@JoinColumn(name = "follower_id")},
            inverseJoinColumns = {@JoinColumn(name = "following_id")}
    )
    private Set<User> following = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Comment> comments = new ArrayList<>();

}
