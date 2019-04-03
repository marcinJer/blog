package com.wojcikjer.blog.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity @Table @Data
public class Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id private Long id;

    private String role;

}
