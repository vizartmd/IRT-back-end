package com.stefanini.irtbackend.model;

import javax.persistence.*;


@Entity
@Table(name = "priority")
public class Priority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}

