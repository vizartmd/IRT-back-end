package com.stefanini.irtbackend.entity;

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
    private User creator;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private Specialty specialty;

    @ManyToOne
    private Status status;

    @OneToMany(mappedBy = "ticket")
    private Set<Action> actionHistory = new HashSet<>();

    @ManyToOne
    private User developer;

    @ManyToOne
    private Priority priority;
}

