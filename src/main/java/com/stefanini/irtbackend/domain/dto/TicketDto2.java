package com.stefanini.irtbackend.domain.dto;

import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.PriorityName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import com.stefanini.irtbackend.domain.entity.enums.StatusName;

import java.io.Serializable;
import java.time.LocalDate;

public class TicketDto2 implements Serializable {

    private Long id;
    private LocalDate createdDate;
    private String title;
    private String description;
    private SpecialtyName specialty;
    private PriorityName priority;
    private StatusName status;
    private User creator;
    private User developer;
    private LocalDate closedDate;

    public TicketDto2() {
    }

    public TicketDto2(Long id, LocalDate createdDate, String title, String description, SpecialtyName specialty, PriorityName priority, StatusName status, User creator, User developer, LocalDate closedDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.priority = priority;
        this.status = status;
        this.creator = creator;
        this.developer = developer;
        this.closedDate = closedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getDeveloper() {
        return developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
    }

    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
    }

    @Override
    public String toString() {
        return "TicketDto2{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", specialty=" + specialty +
                ", priority=" + priority +
                ", status=" + status +
                ", creator=" + creator +
                ", developer=" + developer +
                ", closedDate=" + closedDate +
                '}';
    }
}
