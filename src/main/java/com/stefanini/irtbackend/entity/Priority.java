package com.stefanini.irtbackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "priority")
public class Priority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_priority", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "priority",
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    public Priority() {
    }

    public Priority(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

}

