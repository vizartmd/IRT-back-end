package com.stefanini.irtbackend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status extends AbstractEntity {

    @Column(name = "ticket_status")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "status",
            cascade = CascadeType.ALL)
    private Set<Ticket> tickets = new HashSet<>();

    protected Status() {
    }

    public Status(String name, Set<Ticket> tickets) {
        this.name = name;
        this.tickets = tickets;
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
