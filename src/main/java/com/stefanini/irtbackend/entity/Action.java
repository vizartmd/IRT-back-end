package com.stefanini.irtbackend.entity;

import com.stefanini.irtbackend.enums.Priority;
import com.stefanini.irtbackend.enums.TicketStatus;

import javax.persistence.*;

@Entity
@Table(name = "action")
public class Action extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_id")
    private TicketStatus status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "priority_id")
    private Priority priority;


    public Action() {
    }

    public Action(User user, Ticket ticket, Priority priority, TicketStatus status) {
        this.user = user;
        this.ticket = ticket;
        this.priority = priority;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}