package com.stefanini.irtbackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "priority")
public class Priority extends AbstractEntity {

    @Column(name = "ticket_priority", nullable = false)
    private String name;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "priority",
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    @Override
    public String toString() {
        return "Priority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tickets=" + tickets +
                '}';
    }

    public Priority() {
    }

    public Priority(String name) {
        this.name = name;
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

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}

