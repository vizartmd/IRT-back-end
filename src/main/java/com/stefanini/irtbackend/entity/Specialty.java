package com.stefanini.irtbackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "specialty")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "specialty")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "specialty",
            cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "specialty",
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();
}
