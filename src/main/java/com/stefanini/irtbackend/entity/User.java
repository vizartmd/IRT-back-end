package com.stefanini.irtbackend.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "role_id")
//    private Role role;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "specialty_id")
//    private Specialty specialty;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name", unique = true)
    private String userName;

//    @Column(nullable = false)
//    private String password;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//
//    @OneToMany(mappedBy = "creator")
//    private Set<Ticket> createdTickets = new HashSet<>();
//
//    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
//    @JoinTable(name = "developer_ticket",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "ticket_id"))
//    private Set<Ticket> processingTickets = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public User(Long id, String firstName, String lastName, String userName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public User(String firstName, String lastName, String userName, String password, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//        this.password = password;
//        this.email = email;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public Specialty getSpecialty() {
//        return specialty;
//    }
//
//    public void setSpecialty(Specialty specialty) {
//        this.specialty = specialty;
//    }

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
//
//    public Set<Ticket> getCreatedTickets() {
//        return createdTickets;
//    }
//
//    public void setCreatedTickets(Set<Ticket> createdTickets) {
//        this.createdTickets = createdTickets;
//    }
//
//    public Set<Ticket> getProcessingTickets() {
//        return processingTickets;
//    }
//
//    public void setProcessingTickets(Set<Ticket> processingTickets) {
//        this.processingTickets = processingTickets;
//    }
}