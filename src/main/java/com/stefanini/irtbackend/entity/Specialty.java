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

    public Specialty() {
    }

    public Specialty(Long id, String name, Set<User> users, Set<Ticket> tickets) {
        this.id = id;
        this.name = name;
        this.users = users;
        this.tickets = tickets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
