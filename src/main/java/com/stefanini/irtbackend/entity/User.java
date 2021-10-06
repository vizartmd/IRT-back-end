package com.stefanini.irtbackend.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private int userId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "user_name", unique = true, nullable = false, length = 50)
    private String userName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Ticket> tickets;

    public User() {
    }

    public User(String firstName, String lastName, String userName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public void addTaskToUser(Ticket ticket) {
        if (tickets == null) {
            tickets = new HashSet<>();
        }
        tickets.add(ticket);
        ticket.setUser(this);
    }

    public void addTasksToUser(Set<Ticket> newTickets) {
        if (tickets == null) {
            tickets = newTickets;
        }
        tickets.addAll(newTickets);
        Iterator<Ticket> i= tickets.iterator();
        while(i.hasNext()) {
            i.next().setUser(this);
        }
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        if (tickets == null) {
            this.tickets = null;
        }
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "\nUser [userId =" + userId + ", firstName =" + firstName + ", lastName =" + lastName + ", userName ="
                + userName + "]";
    }

}