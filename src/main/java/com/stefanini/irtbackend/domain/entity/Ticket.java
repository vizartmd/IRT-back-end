package com.stefanini.irtbackend.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
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
    @Column(name = "ticket_priority")
    private PriorityName priority;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "ticket_status")
    private StatusName status;

    @OneToMany(mappedBy = "ticket")
    private Set<Action> actionHistory = new HashSet<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private User creator;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private User developer;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "closed_date", nullable = true)
    private LocalDate closedDate;

    public Ticket(String title, String description, SpecialtyName specialty, PriorityName priority, StatusName status, Set<Action> actionHistory, User creator, User developer) {
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.priority = priority;
        this.status = status;
        this.actionHistory = actionHistory;
        this.creator = creator;
        this.developer = developer;
    }

    public Ticket(String title, String description, SpecialtyName specialty, PriorityName priority, StatusName status, Set<Action> actionHistory, User creator, User developer, LocalDate closedDate) {
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.priority = priority;
        this.status = status;
        this.actionHistory = actionHistory;
        this.creator = creator;
        this.developer = developer;
        this.closedDate = closedDate;
    }

    public Ticket(String title, String description, SpecialtyName specialty, PriorityName priority, StatusName status, User creator) {
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.priority = priority;
        this.status = status;
        this.creator = creator;
    }

    public Ticket() {
    }

    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", specialty=" + specialty +
                ", priority=" + priority +
                ", status=" + status +
                ", creator=" + creator.getUsername() +
                ", developer=" + developer.getUsername() +
                ", closedDate=" + closedDate +
                '}';
    }
}

