package com.stefanini.irtbackend.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id")
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", user=" + user +
                ", ticket=" + ticket +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }

    public Action() {
    }

    public Action(User user, Ticket ticket, Priority priority, Status status) {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
