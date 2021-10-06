package com.stefanini.irtbackend.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id", unique = true, nullable = false)
    private int ticketId;

    @Column(name = "title", unique = false, nullable = false, length = 100)
    private String title;

    @Column(name = "description", unique = false, nullable = false, length = 250)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumn(name = "user_id")
    private User user;

    public Ticket() {
    }

    public Ticket(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Ticket(int ticketId, String title, String description) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
    }

    public Ticket(int user_id, int ticketId, String title, String description) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int taskId) {
        this.ticketId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nTask [ticketId=" + ticketId + ", title=" + title + ", description=" + description + "]";
    }

}
