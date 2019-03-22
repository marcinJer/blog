package com.wojcikjer.blog.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Table
@Data
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String username;

    @Column
    //@JsonIgnore
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "followers",
            joinColumns = {@JoinColumn(name = "follower_id")},
            inverseJoinColumns = {@JoinColumn(name = "following_id")}
    ) @JsonIgnore
    private Set<User> following = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Comment> comments = new ArrayList<>();
}
