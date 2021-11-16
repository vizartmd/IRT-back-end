package com.stefanini.irtbackend.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class TicketDto {
    private String createdDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)

    private String closedDate;
    private String id;
    private String title;
    private String description;
    private String specialty;
    private String priority;
    private String status;
    private String creator;
    private String developer;

    public TicketDto() {
    }

    public TicketDto(String createdDate, String title, String description, String specialty, String priority, String status, String creator, String developer) {
        this.createdDate = createdDate;
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.priority = priority;
        this.status = status;
        this.creator = creator;
        this.developer = developer;
    }

    public TicketDto(String createdDate, String closedDate, String title, String description, String specialty, String priority, String status, String creator, String developer) {
        this.createdDate = createdDate;
        this.closedDate = closedDate;
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.priority = priority;
        this.status = status;
        this.creator = creator;
        this.developer = developer;
    }

    public TicketDto(String createdDate, String closedDate, String id, String title, String description, String specialty, String priority, String status, String creator, String developer) {
        this.createdDate = createdDate;
        this.closedDate = closedDate;
        this.id = id;
        this.title = title;
        this.description = description;
        this.specialty = specialty;
        this.priority = priority;
        this.status = status;
        this.creator = creator;
        this.developer = developer;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "TicketDto{" +
                "createdDate='" + createdDate + '\'' +
                ", closedDate='" + closedDate + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", specialty='" + specialty + '\'' +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", creator='" + creator + '\'' +
                ", developer='" + developer + '\'' +
                '}';
    }
}
