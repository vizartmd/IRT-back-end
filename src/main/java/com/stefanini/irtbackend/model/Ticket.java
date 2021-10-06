package com.stefanini.irtbackend.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="id_creator", nullable=false)
    private User creator;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany
    Set<Action> actionHistory = new HashSet<>();


    @ManyToOne
    User developer;
}

