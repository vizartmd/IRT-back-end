package com.stefanini.IRTbackend.testEntities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Task {

    public Task(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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


    public Task(String title, String description){
        this.title = title;
        this.description = description;
    }

    public Task(String title, String description, User user){
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        if(user != null) {
            return "Task - " + "Title: " + this.title + ", Description: " + this.description + ", Username: " + this.user.getUsername();
        } else {
            return "Task - " + "Title: " + this.title + ", Description: " + this.description;
        }
    }




}
