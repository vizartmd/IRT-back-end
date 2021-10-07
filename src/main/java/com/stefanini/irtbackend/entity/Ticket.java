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
    @Column(name="id_creator", nullable=false)
    private User creator;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @Column(name = "id_specialty")
    private Specialty specialty;

    @ManyToOne
    @Column(name = "id_status")
    private Status status;

    @OneToMany
    private Set<Action> actionHistory = new HashSet<>();

    @ManyToOne
    private User developer;

    @ManyToOne
    @Column(name = "priority")
    private Priority priority;
}

