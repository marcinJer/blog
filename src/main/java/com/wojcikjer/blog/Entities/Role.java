package com.wojcikjer.blog.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity @Table
@Data
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column @JsonIgnore
    private Long id;

    @Column
    private String role;

}
