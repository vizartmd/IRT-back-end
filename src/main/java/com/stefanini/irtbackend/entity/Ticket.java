package com.stefanini.irtbackend.entity;

import com.stefanini.irtbackend.enums.Priority;
import com.stefanini.irtbackend.enums.Specialty;
import com.stefanini.irtbackend.enums.Status;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket extends AbstractEntity {

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "specialty")
    private Specialty specialty;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status_id")
    private Status status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "priority_id")
    private Priority priority;

    @OneToMany(mappedBy = "ticket")
    private Set<Action> actionHistory = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne
    private User developer;

    public Ticket(User creator, String title, String description, Specialty specialty,
                  User developer) {
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.developer = developer;
    }

    public Ticket() {
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<Action> getActionHistory() {
        return actionHistory;
    }

    public void setActionHistory(Set<Action> actionHistory) {
        this.actionHistory = actionHistory;
    }

    public User getDeveloper() {
        return developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
