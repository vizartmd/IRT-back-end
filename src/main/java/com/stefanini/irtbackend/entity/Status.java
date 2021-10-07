package com.stefanini.irtbackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_status")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "status",
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

}
