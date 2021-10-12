package com.stefanini.irtbackend.entity;

import com.stefanini.irtbackend.enums.Role;
import com.stefanini.irtbackend.enums.Specialty;
import com.stefanini.irtbackend.enums.UserStatus;
import jdk.net.SocketFlow;

import javax.persistence.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "specialty")
    private Specialty specialty;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;


    @OneToMany(mappedBy = "creator")
    private Set<Ticket> createdTickets = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "developer_ticket",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "ticket_id"))
    private Set<Ticket> processingTickets = new HashSet<>();

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String firstName, String lastName, String userName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
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

    public Set<Ticket> getCreatedTickets() {
        return createdTickets;
    }

    public void setCreatedTickets(Set<Ticket> createdTickets) {
        this.createdTickets = createdTickets;
    }

    public Set<Ticket> getProcessingTickets() {
        return processingTickets;
    }

    public void setProcessingTickets(Set<Ticket> processingTickets) {
        this.processingTickets = processingTickets;
    }
}
