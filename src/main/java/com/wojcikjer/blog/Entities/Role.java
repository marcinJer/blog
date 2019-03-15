package com.wojcikjer.blog.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity @Table
@Data
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String role;

}
