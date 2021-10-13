package com.stefanini.irtbackend.entity;

import com.stefanini.irtbackend.entity.enums.PriorityName;
import com.stefanini.irtbackend.entity.enums.StatusName;

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
    @Column(name = "action_priority")
    private PriorityName priority;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "action_status")
    private StatusName status;

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

    public Action(User user, Ticket ticket, PriorityName priority, StatusName status) {
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

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }

    public StatusName getStatus() {
        return status;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }
}
