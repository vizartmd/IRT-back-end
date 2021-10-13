package com.stefanini.irtbackend.entity;

import com.stefanini.irtbackend.entity.enums.PriorityName;
import com.stefanini.irtbackend.entity.enums.SpecialtyName;
import com.stefanini.irtbackend.entity.enums.StatusName;

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
    @Column(name = "ticket_specialty")
    private SpecialtyName specialty;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ticket_status")
    private StatusName status;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ticket_priority")
    private PriorityName priority;

    @OneToMany(mappedBy = "ticket")
    private Set<Action> actionHistory = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne
    private User developer;

    public Ticket(User creator, String title, String description, SpecialtyName specialty,
                  User developer) {
        this.creator = creator;
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", specialty=" + specialty +
                ", status=" + status +
                ", priority=" + priority +
                ", actionHistory=" + actionHistory +
                ", creator=" + creator +
                ", developer=" + developer +
                '}';
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

    public SpecialtyName getSpecialty() {
        return specialty;
    }

    public void setSpecialty(SpecialtyName specialty) {
        this.specialty = specialty;
    }

    public StatusName getStatus() {
        return status;
    }

    public void setStatus(StatusName status) {
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

    public PriorityName getPriority() {
        return priority;
    }

    public void setPriority(PriorityName priority) {
        this.priority = priority;
    }
}

